package com.daheremark.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.daheremark.dto.UserDTO;
import com.daheremark.utils.RedisConstants;
import com.daheremark.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.daheremark.utils.RedisConstants.LOGIN_USER_KEY;

/**
 * @author: lipenghui
 * @create: 2022-12-10 14
 **/
public class RefreshTokenInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate=stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头的token
        String token=request.getHeader("authorization");
        if (StrUtil.isBlank(token)) {
            return true;
        }
        //使用token获取redis中的用户
        String userToken=LOGIN_USER_KEY + token;
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(userToken);
        if(userMap.isEmpty()){
            return true;
        }
        //将查询到的Hash数据转为UserDTO
        UserDTO user = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
        UserHolder.saveUser(user);
        //刷新token有效期
        stringRedisTemplate.expire(userToken,RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}

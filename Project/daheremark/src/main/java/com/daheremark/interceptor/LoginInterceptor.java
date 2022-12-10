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

import java.sql.Time;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.daheremark.utils.RedisConstants.LOGIN_USER_KEY;

/**
 * @author: lipenghui
 * @create: 2022-12-10 14
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否需要拦截
        if(UserHolder.getUser()==null){
            response.setStatus(401);
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}

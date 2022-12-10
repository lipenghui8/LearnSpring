package com.daheremark.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daheremark.dto.LoginFormDTO;
import com.daheremark.dto.Result;
import com.daheremark.dto.UserDTO;
import com.daheremark.entity.User;
import com.daheremark.mapper.UserMapper;
import com.daheremark.service.IUserService;
import com.daheremark.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.daheremark.utils.RedisConstants.*;
import static com.daheremark.utils.SystemConstants.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result sendCode(String phone, HttpSession session) {
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.fail("手机号格式错误！");
        }
        //生成验证码
        String code = RandomUtil.randomNumbers(6);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY+phone,code,LOGIN_CODE_TTL, TimeUnit.MINUTES);
        log.debug("发送成功,验证码为{}",code);
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        String phone=loginForm.getPhone();
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.fail("手机号格式错误！");
        }
        String cachecode=stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY+phone);
        String code=loginForm.getCode();
        //校验验证码
        if(cachecode==null||!cachecode.equals(code)){
            return Result.fail("验证码错误！");
        }
        //查询用户是否存在
        User user = query().eq("phone", phone).one();
        if(user==null){
            user=createUserByPhone(phone);
        }
        //生成token作为登录令牌
        String token = UUID.randomUUID().toString(true);
        //将user对象转为hash存储
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(userDTO,
                new HashMap<>(), CopyOptions.create()
                         .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName,fieldValue)->fieldValue.toString()));
        //存储
        String tokenKey=LOGIN_USER_KEY+token;
        stringRedisTemplate.opsForHash().putAll(tokenKey,stringObjectMap);
        //设置token有效期
        stringRedisTemplate.expire(tokenKey,LOGIN_USER_TTL,TimeUnit.MINUTES);
        return Result.ok(token);
    }

    private User createUserByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setNickName(USER_NICK_NAME_PREFIX+RandomUtil.randomString(10));
        save(user);
        return user;
    }
}

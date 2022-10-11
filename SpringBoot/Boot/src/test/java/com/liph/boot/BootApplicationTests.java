package com.liph.boot;

import com.liph.boot.bean.User;
import com.liph.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class BootApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long ll=jdbcTemplate.queryForObject("select count(*) from t_user",Long.class);
        log.info("记录总数：{}",ll);
    }



    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息:{}",user);
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);

    }
}

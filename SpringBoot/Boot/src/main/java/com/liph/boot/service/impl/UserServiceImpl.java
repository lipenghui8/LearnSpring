package com.liph.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liph.boot.bean.User;
import com.liph.boot.mapper.UserMapper;
import com.liph.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Li
 * @create: 2022-10-09 19:03
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

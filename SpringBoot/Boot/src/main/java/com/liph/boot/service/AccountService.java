package com.liph.boot.service;

import com.liph.boot.bean.Account;
import com.liph.boot.mapper.AccountMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Li
 * @create: 2022-10-09 10:11
 **/
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAccById(Long id){
        return accountMapper.getAcct(id);
    }
}

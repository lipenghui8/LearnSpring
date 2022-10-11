package com.liph.boot.service.impl;

import com.liph.boot.bean.Account;
import com.liph.boot.mapper.AccountMapper;
import com.liph.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.Li
 * @create: 2022-10-11 13:14
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Long id){
        return accountMapper.getAcct(id);
    }
}

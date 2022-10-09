package com.liph.boot.mapper;

import com.liph.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Mr.Li
 * @create: 2022-10-09 10:02
 **/
@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}

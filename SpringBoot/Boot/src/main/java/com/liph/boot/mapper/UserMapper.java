package com.liph.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liph.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

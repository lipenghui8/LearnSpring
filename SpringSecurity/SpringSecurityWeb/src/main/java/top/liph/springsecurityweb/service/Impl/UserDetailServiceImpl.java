package top.liph.springsecurityweb.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.liph.springsecurityweb.entity.Users;
import top.liph.springsecurityweb.mapper.UserMapper;

import java.util.List;

/**
 * @author: lipenghui
 * @create: 2022-10-29 22
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询数据库，根据用户名查询
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        //判断
        if(users==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
}

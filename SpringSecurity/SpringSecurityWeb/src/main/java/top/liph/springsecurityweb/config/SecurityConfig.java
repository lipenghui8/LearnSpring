package top.liph.springsecurityweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: lipenghui
 * @create: 2022-10-29 22
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()    //自定义登录页面
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login") //登录访问路径
                .defaultSuccessUrl("/test/index").permitAll() //成功后跳转路径
                .and().authorizeRequests()
                .antMatchers("/","/test/hello","/user/login").permitAll() //不需要认证的路径
                .anyRequest().authenticated()
                .and().csrf().disable(); //关闭csrf防护
    }
}

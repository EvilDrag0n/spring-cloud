package info.lxlong.cloud.config;

import info.lxlong.cloud.entity.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.config
 * @ClassName: WebSecurityConfig
 * @Author: lxlong
 * @Date: 2019-04-03 15:50
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        //所有请求都需要经过HTTP basic认证
       http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //明文编码
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(new MyPasswordEncoder());
    }

    @Autowired
    private CustomUserDetailsService userDetailsService;

    /**
     * 添加注解扫描
     */
    @Component
    class CustomUserDetailsService implements UserDetailsService {

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            if("admin".equals(userName)) {
                return new SecurityUser("admin", "admin1", "admin-1");
            } else if ("user".equals(userName)) {
                return new SecurityUser("user", "user1", "user-1");
            }
            return null;
        }
    }

    class MyPasswordEncoder implements PasswordEncoder{

        @Override
        public String encode(CharSequence rawPassword) {
            // TODO Auto-generated method stub
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            // TODO Auto-generated method stub
            return encodedPassword.equals(rawPassword.toString());
        }
    }
}

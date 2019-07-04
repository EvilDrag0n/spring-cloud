package info.lxlong.cloud.controller;

import info.lxlong.cloud.dao.UserRepository;
import info.lxlong.cloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.Collection;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:15:19
 */
@RestController
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                logger.info("当前用户是{},角色是{}", user.getUsername(), authority.getAuthority());
            }
        } else {
            //do something
        }

        logger.info("请求进来了");

        User user = this.userRepository.findOne(id);
        return user;
    }
    
    @GetMapping("/save")
    public User save(User user) {
        user = this.userRepository.save(user);
        return user;
    }
}

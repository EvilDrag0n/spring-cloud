package info.lxlong.cloud.controller;

import info.lxlong.cloud.dao.UserRepository;
import info.lxlong.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:15:19
 */
@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = this.userRepository.findOne(id);
        return user;
    }
    
    @GetMapping("/save")
    public User save(User user) {
        user = this.userRepository.save(user);
        return user;
    }
}

package info.lxlong.cloud.controller;

import info.lxlong.cloud.inteface.UserFeignClient;
import info.lxlong.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:16:35
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    
    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }
}

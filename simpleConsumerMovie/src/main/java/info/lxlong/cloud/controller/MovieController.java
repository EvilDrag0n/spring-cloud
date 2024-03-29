package info.lxlong.cloud.controller;

import info.lxlong.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:16:35
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    //获取配置文件中变量值
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return this.restTemplate.getForObject(userServiceUrl + id, User.class);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}

package info.lxlong.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import info.lxlong.cloud.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    /**
     *
     */
    @Autowired
    private RestTemplate restTemplate;
    /**
     *
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //获取配置文件中变量值
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*
     * 不可将restTemplate.getForObject() 和 loadBancerClient.choose() 写在同一个方法中，
     * 因为会产生冲突。 restTemplate 实际上就是一个 ribbon客户端 包含了 choose() 操作
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    /*
     *@HystrixCommand 使方法具有容错能力
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User getUserInfo(@PathVariable Long id) {
        /*  microservice-provider-user 为微服务的虚拟主机名。 默认情况下 虚拟主机名就是 服务提供者的服务名
        *   也可以使用eurek a配置虚拟主机名 eureka.instance.virtual-host-name 或者 eureka.instance.secure-virtual-host-name
        *
        *   当 Eureka 和 Ribbon 整合时，Ribbon会自动把 虚拟主机名 映射到 服务地址
        */
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }


    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("defaultUser");
        return user;
    }

    @GetMapping("/log-instance")
    public void getLogInstance() {
        //通过ribbon获取节点
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");

        logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}

package info.lxlong.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:15:21
 */
// @EnableDiscoveryClient 是各种服务组件提供了支持 例如：Zookeeper、Consul、Eureka等
// @EnableDiscoveryClient 是spring-cloud-commons项目中的注解。是一个高度抽象注解
// 也可以用   @EnableEurekaClient 。但是该注解仅 支持 eureka
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserWithAtuhApplication {
    
    public static void main(String[]args){
        SpringApplication.run(ProviderUserWithAtuhApplication.class, args);
    }

}

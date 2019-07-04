package info.lxlong.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

//集成hystrix 后 须在启动类添加注解 @EnableHystrix 或者 @EnableCircuitBreaker
@EnableHystrix
//@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class SimpleconsumerMovieRibbonHystrixApplication {

    /**
     * 添加 LoadBalanced 注解即可吧 restTemplate 整合到 ribbon
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleconsumerMovieRibbonHystrixApplication.class, args);
    }
}

package info.lxlong.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SimpleconsumermovieFeignApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleconsumermovieFeignApplication.class, args);
    }
}

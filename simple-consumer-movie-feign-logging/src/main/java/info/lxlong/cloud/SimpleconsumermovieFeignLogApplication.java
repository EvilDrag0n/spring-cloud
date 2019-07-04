package info.lxlong.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
//排除部分扫描
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {info.lxlong.cloud.annotation.ExcludeComponent.class}))
public class SimpleconsumermovieFeignLogApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleconsumermovieFeignLogApplication.class, args);
    }
}

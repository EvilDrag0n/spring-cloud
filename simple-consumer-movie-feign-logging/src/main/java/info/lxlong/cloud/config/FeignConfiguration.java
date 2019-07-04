package info.lxlong.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.config
 * @ClassName: FeignConfigration
 * @Author: lxlong
 * @Date: 2019-04-03 17:39
 * @Version: 1.0
 */
@Configuration
public class FeignConfiguration {

    /**
     * 输出所有日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}

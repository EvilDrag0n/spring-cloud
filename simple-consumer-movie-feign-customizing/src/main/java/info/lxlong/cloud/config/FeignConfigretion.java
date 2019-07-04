package info.lxlong.cloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 自定义配置类
 *
 *  * 对于使用Java代码自定义Feign配置的过程中，可指定该配置只对某个Feign客户端生效，也可对所有的Feign客户端生效
 *  * 只对某个Feign客户端生效，则FeignConfiguration类不能包含在主应用程序上下文的@CompantScan中,在主程序添加排除
 *  * 对所有的Feign客户端生效，只须将FeignConfiguration类包含在主应用程序上下文的@CompantScan中即可
 *
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.config
 * @ClassName: FeignConfigretion
 * @Author: lxlong
 * @Date: 2019-04-03 15:30
 * @Version: 1.0
 */
@Configuration
public class FeignConfigretion {

    /**
     * 自定义 Feign 契约
     * @return Contract 默认契约
     */
    @Bean
    public Contract geignContract(){
        return new Contract.Default();
    }
}

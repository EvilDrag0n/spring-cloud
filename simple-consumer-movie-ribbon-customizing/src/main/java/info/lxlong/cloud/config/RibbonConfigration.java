package info.lxlong.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 自定义配置
 *
 * 对于使用Java代码自定义Ribbon配置的过程中，可指定该配置只对某个Ribbon客户端生效，也可对所有的Ribbon客户端生效
 * 只对某个Ribbon客户端生效，则RibbonConfiguration类不能包含在主应用程序上下文的@CompantScan中
 * 对所有的Ribbon客户端生效，只须将RibbonConfiguration类包含在主应用程序上下文的@CompantScan中即可
 *
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.config
 * @ClassName: RibbonConfigration
 * @Author: lxlong
 * @Date: 2019-04-03 11:28
 * @Version: 1.0
 */
@Configuration
public class RibbonConfigration {

    @Bean
    public IRule ribbonRule() {
        //负载规则改为随机
        return new RandomRule();
    }
}

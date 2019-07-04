package info.lxlong.cloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.config
 * @ClassName: TestRibbonConfigration
 * @Author: lxlong
 * @Date: 2019-04-03 11:32
 * @Version: 1.0
 */
@Configuration
@RibbonClient(name = "microservice-provider-user",configuration = RibbonConfigration.class)
public class TestRibbonConfigration {
}

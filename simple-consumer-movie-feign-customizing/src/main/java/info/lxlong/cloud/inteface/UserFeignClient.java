package info.lxlong.cloud.inteface;

import feign.Param;
import feign.RequestLine;
import info.lxlong.cloud.config.FeignConfigretion;
import info.lxlong.cloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.inteface
 * @ClassName: UserFeignClient
 * @Author: lxlong
 * @Date: 2019-04-03 13:44
 * @Version: 1.0
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfigretion.class)
public interface UserFeignClient {

    /**
     * 使用Feign自带的注解 @RequestLine
     *
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}

package info.lxlong.cloud.inteface;

import info.lxlong.cloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: simple
 * @Package: info.lxlong.cloud.inteface
 * @ClassName: UserFeignClient
 * @Author: lxlong
 * @Date: 2019-04-03 13:44
 * @Version: 1.0
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable(name = "id") Long id);
}

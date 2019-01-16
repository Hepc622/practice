package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/8/24 0024.
 */
//指定要调用的服务名，这里还指定了断路器回调处理方法
@FeignClient(value="client1",fallback = HytrixServiceImp.class)
@Component
public interface  FeignService{
//    指定调用的url控制器
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String feignHello();
}

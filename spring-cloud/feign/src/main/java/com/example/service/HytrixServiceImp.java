package com.example.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/24 0024.
 */
@Component
public class HytrixServiceImp implements FeignService {
    @Override
    public String feignHello() {
        return "服务器挂了，暂时不能访问";
    }
}

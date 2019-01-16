package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/24 0024.
 */
@RestController
public class HystrixController {

    @Autowired
    public HytrixService hytrixService;

    @RequestMapping("/hello")
    public String hystrixHello(){
        return hytrixService.hystrixHello();
    }
}

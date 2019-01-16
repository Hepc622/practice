package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/8/24 0024.
 */

@Service
public class HytrixService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hystrixHello() {
        return restTemplate.getForObject("http://client1/hello",String.class);
    }

    public String hiError() {
        return "hi,sorry,error!";
    }
}

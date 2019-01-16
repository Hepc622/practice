package com.example.controller;

import com.home.practive.ClientApi;
import com.home.practive.vo.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
     * Created by Administrator on 2018/8/24 0024.
     */
@RestController
public class FeignController {


//    @Autowired
//    FeignService feignService;
    @Autowired
    private ClientApi clientApi;

    @GetMapping("/feignHello")
    public MemberUser feignHello(){

        System.out.println("do some thing");
        MemberUser memberUser = clientApi.sayHello();
        memberUser.setName("zll");
        return memberUser;
    }
}
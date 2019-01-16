package com.home.controller;

import com.home.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 * 作者：HPC
 * 时间：2018-09-24 00：03
 */
@RestController
public class DubboController {
    @Autowired
    private DubboService dubboService;

    @RequestMapping("/getNmme")
     public String getName(String name){
         return this.dubboService.getName(name);
     }
}

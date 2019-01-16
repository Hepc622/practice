package com.home.dubbo.service;

import com.home.service.DubboService;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * 作者：HPC
 * 时间：2018-09-24 12：30
 */
@Service("userService")
public class UserServiceImpl implements DubboService {
    @Override
    public String getName(String name) {
        return "your name is " + name;
    }
}

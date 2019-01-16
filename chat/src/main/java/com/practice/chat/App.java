package com.practice.chat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * 描述：
 * 作者：HPC
 * 时间：2018-12-05 16：08
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/spring-app.xml");
        final RedisTemplate<String, String> redisTemplate;
        redisTemplate = (RedisTemplate<String, String> ) ac.getBean("redisTemplate");
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    redisTemplate.opsForValue().set("1","2");
                }
            }).start();
        }
    }
}

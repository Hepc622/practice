package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/*spring boot 1.5的版本
通过@EnableDiscoveryClient向服务中心注册；
并且向程序的ioc注入一个bean: restTemplate;
并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
* */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@GetMapping("/ribbon")
	public String ribbon(){
		return restTemplate().getForObject("http://CLIENT1/hello",String.class);
	}
}

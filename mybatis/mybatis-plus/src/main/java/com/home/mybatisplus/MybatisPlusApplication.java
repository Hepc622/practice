package com.home.mybatisplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MybatisPlusApplication {

	@Autowired
	private MemberMapper memberMapper;
	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}

	@RequestMapping("/getMember")
	public List getMember() {
		List<Member> member = memberMapper.getMember();
		Member m = memberMapper.selectById(1);
		return member;
	}

}


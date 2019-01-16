package com.practice.chat.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.chat.bean.User;
import com.practice.chat.service.IUserService;

@Service
public class OurUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserService userService;

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		List<User> list = userService.getUserByNames(arg0);
		if(list!=null&&list.size()>0) {
			//一个用户有可能有多个角色所以是一个数组，这里默认给user
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			User user =list.get(0);
			return new OurUser(user.getcId(), user.getcNickname(), user.getcEmail(),user.getcPassword(),grantedAuthorities);
		}else {
			throw new UsernameNotFoundException("该用户不存在！");
		}
	}

}

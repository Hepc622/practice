package com.practice.chat.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Administrator
 * 当前用户
 */
public class CurrentUser {
	public static OurUser getCurrentUser() {
		//获取当前用户的信息		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((OurUser) principal);
		}
		return null;
	} 
}

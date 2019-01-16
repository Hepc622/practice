

package com.hniu.ognl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hniu.comparator.UserComparator;
import com.hniu.user.User;

public class Ognl {
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String property() {
		return "property";
	}

	public String url() {
		return "url";
	}

	public String set() {
		return "set";
	}

	public String push() {
		return "push";
	}

	public String if_else_if() {
		return "if_else_if";
	}

	public String iterator() {
		List<Object> list = new ArrayList<Object>();
		list.add(new User("hpc", "男", 21));
		list.add(new User("zll", "女", 21));
		list.add(new User("lyl", "女", 21));
		user.setList(list);
		return "iterator";
	}

	public String sort() {
		List<Object> list = new ArrayList<Object>();
		list.add(new User("hpc", "男", 21));
		list.add(new User("zll", "女", 21));
		list.add(new User("lyl", "女", 21));
		list.add(new User("zb", "男", 22));
		list.add(new User("trj", "男", 21));
		user.setComparator(new UserComparator());
		user.setList(list);
		return "sort";
	}

	public String date() {
		user.setDate(new Date());
		return "date";
	}
	
	public String save() {
		return "save";
	}
	public String city() {
		return "city";
	}
		
	public String checkboxlist() {
		return "checkboxlist";
	}
}

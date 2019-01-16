package com.hniu.comparator;

import java.util.Comparator;

import com.hniu.user.User;

public class UserComparator implements Comparator<User> {

	public int compare(User o1, User o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

package com.hniu.spring.beans.annotation;

import org.springframework.stereotype.Component;

@Component
public class Person {
	@Override
	public String toString() {	
		return "person";
	}
}

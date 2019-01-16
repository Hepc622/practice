package com.hniu.spring.beans.hello;

public class Hello {

	private String name;
	public void setName(String name){
		this.name = name;
	}
	public void showName(){
		System.out.println(name);
	}
	public Hello() {
		System.out.println("我被创建了");
	}
	
}

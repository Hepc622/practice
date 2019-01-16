package com.hniu.action.stack;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String execute() throws Exception {
		System.out.println(person);
		return super.execute();
	}
}

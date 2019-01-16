package com.hniu.spring.strus.action;

import com.hniu.spring.strus.service.PersonService;

public class PersonAction {
	private PersonService peronService;
	public PersonService getPeronService() {
		return peronService;
	}
	public void setPeronService(PersonService peronService) {
		this.peronService = peronService;
	}
	public String execute(){
		peronService.save();
		return "success";
	}
	
}

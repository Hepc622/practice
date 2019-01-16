package com.hniu.hibernate.n2n.bean;


import java.util.HashSet;
import java.util.Set;

public class Categorie {

	private int id;
	private String name;
	
	private Set<Item> item = new HashSet<Item>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItem() {
		return item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public Categorie(String name, Set<Item> item) {
		super();
		this.name = name;
		this.item = item;
	}

	public Categorie() {
		super();
	}
	
}

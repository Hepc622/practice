package com.hniu.hibernate.n2n.bean;

import java.util.HashSet;
import java.util.Set;

public class Item {

		private int id;
		private String name;
		private Set<Categorie> categorie = new HashSet<Categorie>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<Categorie> getCategorie() {
			return categorie;
		}
		public void setCategorie(Set<Categorie> categorie) {
			this.categorie = categorie;
		}
		public Item(String name, Set<Categorie> categorie) {
			super();
			this.name = name;
			this.categorie = categorie;
		}
		public Item() {
			super();
		}
		
}

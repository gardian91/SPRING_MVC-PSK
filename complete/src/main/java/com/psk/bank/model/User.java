package com.psk.bank.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String id;
	private String name;
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	User()
	{}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

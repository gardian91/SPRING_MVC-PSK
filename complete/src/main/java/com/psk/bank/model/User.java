package com.psk.bank.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String id;
	private String name;
	private LocalDateTime date;


	public User(String id, String name, LocalDateTime date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
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
	
	//@JsonFormat(pattern="yyyy-MM-dd") 
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}

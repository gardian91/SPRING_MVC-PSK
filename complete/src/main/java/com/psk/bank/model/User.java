package com.psk.bank.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Component
public class User {

	private String id;
	private String name;
	private LocalDateTime date;


	public User(String id, String name, LocalDateTime date) {
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
	
	//@JsonFormat(pattern="yyyy-MM-dd") 
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}

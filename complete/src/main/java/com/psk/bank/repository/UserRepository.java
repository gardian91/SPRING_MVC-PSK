package com.psk.bank.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.psk.bank.model.User;

@Component
public class UserRepository {

	private Map<String, User> storage = new HashMap<>();

	  public UserRepository() {
      
          save(new User("1","User1"));
          save(new User("2","User2"));
          save(new User("3","User3"));
      }
	
	
	
	public User save(User object) {
		storage.put(object.getId(), object);
	    return object;
	    
	}

	
	public User findOne(String id) {
		return storage.get(id);
	}
	
	public User deleteOne (String id){
		return storage.remove(id);
	}

	
	public List<User> findAll() {
		return storage.values().stream().collect(Collectors.toList());
	}

}

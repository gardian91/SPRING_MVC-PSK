package com.psk.bank.repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.psk.bank.model.Account;
import com.psk.bank.model.AccountEntity;


public class AccountRepository  implements Repository<Account, String>{

        private Map<String, Account> storage = new HashMap<>();
        
        public AccountRepository() {
        	DateTime date = DateTime.parse("04/02/2011 20:27:05", 
                    DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"));
            save(AccountEntity.newInstance("ABC1","Jan","Kowalski",true, date));
            save(AccountEntity.newInstance("ABC2","Tomasz","Kot",true, date));
            save(AccountEntity.newInstance("ABC3","Jan","Kowalski",true, date));
        }
    
	@Override
	public void save(Account object) {
	    storage.put(object.getAccountNumber(), object);
	}

	@Override
	public Account findOne(String accountNumber) {
		return storage.get(accountNumber);
	}

	@Override
	public List<Account> findAll() {
		return storage.values().stream().collect(Collectors.toList());
	}


}

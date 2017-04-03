package com.psk.bank.resources;

import java.time.LocalDate;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psk.bank.model.Account;
import com.psk.bank.model.AccountEntity;
import com.psk.bank.repository.AccountRepository;

@RequestMapping(value = "/accounts")
@RestController
public class AccountsResource {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountRepository.findOne(accountNumber);
    }

    @RequestMapping("/added-since/{since}")
    public String showAddedSince(
            @PathVariable("since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since) {
        return "companies-added-since" + since.toString();
    }

    @PostMapping("/")
    public Account createAccount(@RequestBody Account account) {
        accountRepository.save(account);
        return accountRepository.findOne(account.getAccountNumber());
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("MM-dd-yyyy"));
    }


}

package com.topnotch.resourceserver.controller;

import com.topnotch.resourceserver.model.Accounts;
import com.topnotch.resourceserver.model.Customer;
import com.topnotch.resourceserver.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByEmail(customer.getEmail());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}

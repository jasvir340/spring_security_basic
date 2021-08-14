package com.topnotch.springsecuritysection2.service;

import com.topnotch.springsecuritysection2.model.Customer;
import com.topnotch.springsecuritysection2.model.SecurityCustomer;
import com.topnotch.springsecuritysection2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JassiBankUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByEmail(username);
        if(customers.size() == 1){
            return new SecurityCustomer(customers.get(0));
        }else if(customers.size() == 0){
            throw new UsernameNotFoundException(username+" is not a valid User");
        }else{
            throw new UsernameNotFoundException(username+" multiple users registered with the same email !!");
        }
    }
}

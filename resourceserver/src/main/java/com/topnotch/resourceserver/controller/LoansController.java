package com.topnotch.resourceserver.controller;

import com.topnotch.resourceserver.model.Customer;
import com.topnotch.resourceserver.model.Loans;
import com.topnotch.resourceserver.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

	@Autowired
	private LoanRepository loanRepository;

	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		return loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
	}
}

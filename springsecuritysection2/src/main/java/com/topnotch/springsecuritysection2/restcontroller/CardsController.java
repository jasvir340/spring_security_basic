package com.topnotch.springsecuritysection2.restcontroller;

import com.topnotch.springsecuritysection2.model.Cards;
import com.topnotch.springsecuritysection2.model.Customer;
import com.topnotch.springsecuritysection2.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

	@Autowired
	private CardsRepository cardsRepository;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		return cardsRepository.findByCustomerId(customer.getId());
	}
}

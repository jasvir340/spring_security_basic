package com.topnotch.springsecuritybasic.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcom")
	public String sayWelcome() {
		return "Welcome from Spring Application with out Security";
	}
	
}

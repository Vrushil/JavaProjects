package com.vrushil.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	

	@GetMapping("/")
	public void home()
	{
		
		System.out.println("In Common area");
	}

	@GetMapping("/user")
	public void user()
	{
		
		System.out.println("In User area");
	}
	
	@GetMapping("/admin")
	public void admin()
	{
		
		System.out.println("In admin area");
	}
	
}

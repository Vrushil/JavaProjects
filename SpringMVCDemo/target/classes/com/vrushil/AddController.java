package com.vrushil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class AddController {

	@RequestMapping(path="/add")
	public void add()
	
	{
		System.out.println("In add method");
	}
}

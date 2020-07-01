package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home()
	{
	//	System.out.println("In home method");
 return "home.jsp";   // This will download  home.jsp loacted  in webapp folder. Searching the ifle in project  is autoconfigured
	}

}
 
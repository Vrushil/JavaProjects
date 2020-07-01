package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	@ResponseBody  // This will print the return string on the web page . Spring boot does not support jsp by default. After adding dependencies in pom.xml for tomcat jasper. This wll help to return the page
	public String home()
	{
	//	System.out.println("In home method");
 return "home";   // This will download  home.jsp loacted  in webapp folder. Searching the ifle in project  is autoconfigured
	}

}
 
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("index")
	@ResponseBody
	public String add()
	{
		System.out.println("In home method");
		return "index";
				// This will download  home.jsp loacted  in webapp folder. Searching the ifle in project  is autoconfigured
	}

}
 
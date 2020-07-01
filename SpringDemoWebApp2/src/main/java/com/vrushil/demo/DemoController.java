package com.vrushil.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@RequestMapping("home")
	public String home(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name= req.getParameter("name"); 
		System.out.println("In print function");
	session.setAttribute("name", name);
		return "home";
	}

}

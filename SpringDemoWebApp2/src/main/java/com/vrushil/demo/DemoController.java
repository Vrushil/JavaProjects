package com.vrushil.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	@RequestMapping("home")
	public ModelAndView home() {

		System.out.println("In print function");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("student")
	public ModelAndView student(@RequestParam("email") String email,@RequestParam("college") String college,@RequestParam("major") String major,@RequestParam("gpa") String gpa) {

		System.out.println("In student page");
		ModelAndView mv = new ModelAndView();
		
		
		  mv.addObject("email",email);
		  
		  mv.addObject("college",college); mv.addObject("major",major);
		  mv.addObject("gpa",gpa);
		 
		  mv.setViewName("student");
		 
		return mv;
	}

}

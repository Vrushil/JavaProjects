package com.vrushil.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vrushil.demo.dao.AlienRepo;
import com.vrushil.demo.model.Alien;
@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home";
	}
	
	@RequestMapping("getAlien")
	public ModelAndView getAlien(int aid)
	{
		
		ModelAndView mv= new ModelAndView("show");
	Alien alien = repo.findById(aid).orElse(new Alien());
	System.out.println(repo.findByTech("java"));
	mv.addObject(alien);
		return mv;
	}
}

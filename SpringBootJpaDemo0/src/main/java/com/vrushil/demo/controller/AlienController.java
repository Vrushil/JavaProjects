package com.vrushil.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home";
	}
}

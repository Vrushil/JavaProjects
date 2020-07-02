package com.vrushil.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/aliens") // Rest API type URL
	@ResponseBody
	public String getAliens()
	{
return repo.findAll().toString(); //fetching records s
	}
	
	@RequestMapping("/alien/{aid}") // Rest API type URL
	@ResponseBody
	public String getAlien( @PathVariable("aid") int aid)
	{
return repo.findById(aid).toString(); //fetching records s
	}
}

package com.vrushil.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	//After adding jackson databind xml, The client can have acces to json and xml  type of response. This is called as content negotiation
	@RequestMapping(path= "/aliens",produces = {"application/xml"}) // Rest API type URL; The produces command can produce only the mentioned format of  response. hence if the user tries to get json format , it will report unacceptable
	@ResponseBody
	public List<Alien> getAliens()
	{
return repo.findAll(); //fetching records in jSON format
	}
	
	@RequestMapping("/alien/{aid}") // Rest API type URL
	@ResponseBody
	public Optional<Alien> getAlien( @PathVariable("aid") int aid)
	{
return repo.findById(aid); //fetching records s
	}
}

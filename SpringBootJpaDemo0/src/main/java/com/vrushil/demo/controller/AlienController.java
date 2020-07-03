package com.vrushil.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrushil.demo.dao.AlienRepo;
import com.vrushil.demo.model.Alien;
@RestController   // If we use rest controller the n by default all the methods would return the response in JSON or XML format for rest api and we do not need to add Response body annotation before the method
public class AlienController {
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@PostMapping(path = "alien", consumes = {"application/json"} ) // The data which is accepted by server is known as consumed . We can control the type of data that is accepted by the server so her we are accepting only JSON data format
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	
	//After adding jackson databind xml, The client can have acces to json and xml  type of response. This is called as content negotiation
	@RequestMapping(path= "/aliens") // Rest API type URL; The produces command can produce only the mentioned format of  response. hence if the user tries to get json format , it will report unacceptable
	
	public List<Alien> getAliens()
	{
return repo.findAll(); //fetching records in jSON format
	}
	
	@RequestMapping("/alien/{aid}") // Rest API type URL
	
	public Optional<Alien> getAlien( @PathVariable("aid") int aid)
	{
return repo.findById(aid); //fetching records s
	}
}

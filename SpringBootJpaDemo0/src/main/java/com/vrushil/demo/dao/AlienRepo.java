package com.vrushil.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.vrushil.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer >
{

}

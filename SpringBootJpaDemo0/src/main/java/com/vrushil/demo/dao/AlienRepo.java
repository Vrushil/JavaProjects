package com.vrushil.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrushil.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer >
{

	
}

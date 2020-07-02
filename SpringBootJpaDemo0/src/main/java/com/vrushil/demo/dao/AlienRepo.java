package com.vrushil.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vrushil.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer >
{

	List<Alien> findByTech(String string); // Automatically writes the qury to find a record by its technology
List<Alien> findByAidGreaterThan(int num);
@Query("from Alien where tech =?1 order by aname ") // It is a JPQL query Similar to HQL
List<Alien> findByTechSorted(String tech);
}

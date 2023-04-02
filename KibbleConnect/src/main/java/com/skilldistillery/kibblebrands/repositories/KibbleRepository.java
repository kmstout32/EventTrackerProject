package com.skilldistillery.kibblebrands.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.kibblebrands.entities.Kibble;

public interface KibbleRepository extends JpaRepository<Kibble, Integer> {

	Kibble findById(int kibbleId);
//	List<Kibble> findByNameLike(String name);
	
}

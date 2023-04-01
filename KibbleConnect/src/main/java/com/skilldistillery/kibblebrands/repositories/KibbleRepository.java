package com.skilldistillery.kibblebrands.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.kibblebrands.entities.Kibble;

public interface KibbleRepository extends JpaRepository<Kibble, Integer> {

	
}

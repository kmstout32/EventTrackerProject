package com.skilldistillery.kibblebrands.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.kibblebrands.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}

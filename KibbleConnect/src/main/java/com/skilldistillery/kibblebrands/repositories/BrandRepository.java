package com.skilldistillery.kibblebrands.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.kibblebrands.entities.Brand;
import com.skilldistillery.kibblebrands.entities.Kibble;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	Brand findById(int brandId);
//	List<Brand> findByBrandId(int brandId );
//	List<Brand> findByNameLike(String name);
}

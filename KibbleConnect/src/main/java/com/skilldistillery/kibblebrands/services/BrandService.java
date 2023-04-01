package com.skilldistillery.kibblebrands.services;

import java.util.List;

import com.skilldistillery.kibblebrands.entities.Brand;

public interface BrandService {

	List<Brand> listAll();
	Brand getBrand(int brandId);
	Brand create(Brand brand);
	Brand update(int brandId, Brand brand);
	boolean deleteById(int brandId);
}

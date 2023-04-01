package com.skilldistillery.kibblebrands.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.kibblebrands.entities.Brand;
import com.skilldistillery.kibblebrands.repositories.BrandRepository;
import com.skilldistillery.kibblebrands.repositories.KibbleRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepo;
	
	@Override
	public List<Brand> listAll() {
		// TODO Auto-generated method stub
		return brandRepo.findAll();
	}

	@Override
	public Brand getBrand(int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand create(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand update(int brandId, Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int brandId) {
		// TODO Auto-generated method stub
		return false;
	}


}

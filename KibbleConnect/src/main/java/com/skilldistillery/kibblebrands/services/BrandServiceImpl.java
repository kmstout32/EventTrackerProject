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
		return brandRepo.findAll();
	}

	@Override
	public Brand getBrandById(int brandId) {
		return brandRepo.findById(brandId);
	}

	@Override
	public Brand create(Brand brand) {
		return brandRepo.saveAndFlush(brand);
	}

	@Override
	public Brand update(int brandId, Brand brand) {
		Brand existingBrand = brandRepo.findById(brandId);
		if(existingBrand != null) {
			existingBrand.setName(brand.getName());
			existingBrand.setImageLogo(brand.getImageLogo());
			return brandRepo.saveAndFlush(null);
		}
		return null;
	}

	@Override
	public boolean deleteById(int brandId) {
		boolean deleted = false;
		Brand brandToDelete = brandRepo.findById(brandId);
		if(brandToDelete != null) {
			brandRepo.delete(brandToDelete);
			deleted = true;
		}
		return deleted;
	}


}

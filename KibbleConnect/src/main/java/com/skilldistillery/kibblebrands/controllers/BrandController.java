package com.skilldistillery.kibblebrands.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.kibblebrands.entities.Brand;
import com.skilldistillery.kibblebrands.entities.Kibble;
import com.skilldistillery.kibblebrands.services.BrandService;
import com.skilldistillery.kibblebrands.services.KibbleService;

@RestController
@RequestMapping("api")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping("brands")
	private List<Brand> getKibbleList(){
		return brandService.listAll();
	}
	
	@GetMapping("brands/{brandId}")
	public Brand getBrandById(@PathVariable Integer brandId, HttpServletResponse res) {
		Brand newBrand = brandService.getBrandById(brandId);
		return newBrand;
		
	}
	
	@PostMapping("brands")
	public Brand addBrand(@RequestBody Brand brand, HttpServletResponse res,
			HttpServletRequest req) {
		try {
			brand = brandService.create(brand);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(brand.getId());
			res.setHeader("Location", url.toString());
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			brand = null;
			
		}
		return brand;
	}
	
	@PutMapping("brands/{brandId}")
	public Brand updateBrand(@PathVariable Integer brandId,
			@RequestBody Brand brand, HttpServletResponse res) {
		try {
			brand = brandService.update(brandId, brand);
			if (brand == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			brand = null;
		}
		return brand;
	
	}
	
	@DeleteMapping("brands/{brandId}")
	public void deleteBrand(@PathVariable Integer brandId, HttpServletResponse res) {
		try { 
			if(brandService.deleteById(brandId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
	}
}

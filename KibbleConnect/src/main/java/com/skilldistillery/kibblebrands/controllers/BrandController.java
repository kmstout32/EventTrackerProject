package com.skilldistillery.kibblebrands.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.kibblebrands.entities.Brand;
import com.skilldistillery.kibblebrands.services.BrandService;

@RestController
@RequestMapping("api")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping("brands")
	private List<Brand> getKibbleList(){
		return brandService.listAll();
	}
}

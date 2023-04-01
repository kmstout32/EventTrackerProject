package com.skilldistillery.kibblebrands.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.kibblebrands.entities.Kibble;
import com.skilldistillery.kibblebrands.services.KibbleService;

@RestController
@RequestMapping("api")
public class KibbleController {

	@Autowired
	private KibbleService kibbleService;
	
	@GetMapping("kibbles")
	private List<Kibble> getKibbleList(){
		return kibbleService.listAll();
	}
}

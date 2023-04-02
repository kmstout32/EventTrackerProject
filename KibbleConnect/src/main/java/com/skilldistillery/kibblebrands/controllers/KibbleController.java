package com.skilldistillery.kibblebrands.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("kibbles/{kibbleId}")
	public Kibble getKibbleById(@PathVariable Integer kibbleId, HttpServletResponse res) {
		Kibble newKibble = kibbleService.getKibbleById(kibbleId);
		return newKibble;
		
	}
	
	@PostMapping("kibbles")
	public Kibble addKibble(@RequestBody Kibble kibble, HttpServletResponse res,
			HttpServletRequest req) {
		try {
			kibble = kibbleService.create(kibble);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(kibble.getId());
			res.setHeader("Location", url.toString());
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			kibble = null;
			
		}
		return kibble;
	}
	
	@PutMapping("kibbles/{kibbleId}")
	public Kibble updateKibble(@PathVariable Integer kibbleId,
			@RequestBody Kibble kibble, HttpServletResponse res) {
		try {
			kibble = kibbleService.update(kibbleId, kibble);
			if (kibble == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			kibble = null;
		}
		return kibble;
	
	}
	
	@DeleteMapping("kibbles/{kibbleId}")
	public void deleteKibble(@PathVariable Integer kibbleId, HttpServletResponse res) {
		try { 
			if(kibbleService.deleteById(kibbleId)) {
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
     
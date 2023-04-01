package com.skilldistillery.kibblebrands.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.kibblebrands.entities.Kibble;
import com.skilldistillery.kibblebrands.repositories.KibbleRepository;

@Service
public class KibbleServiceImpl implements KibbleService{

	@Autowired
	private KibbleRepository kibbleRepo;
	@Override
	public List<Kibble> listAll() {
		
		System.out.println("***************");
		System.out.println(kibbleRepo.findAll());
		return kibbleRepo.findAll();
	}

	@Override
	public Kibble getKibble(int kibbleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kibble create(Kibble kibble) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kibble update(int kibbleId, Kibble kibble) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int kibbleId) {
		// TODO Auto-generated method stub
		return false;
	}

}

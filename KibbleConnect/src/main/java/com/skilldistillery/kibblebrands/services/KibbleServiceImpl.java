package com.skilldistillery.kibblebrands.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.kibblebrands.entities.Kibble;
import com.skilldistillery.kibblebrands.repositories.KibbleRepository;

@Service
public class KibbleServiceImpl implements KibbleService{

	@Autowired
	private KibbleRepository kibbleRepo;
	
//	----FIND KIBBLE LIST-----------------------------------------------------
	@Override
	public List<Kibble> listAll() {
		
		return kibbleRepo.findAll();
	}
//	----FIND A KIBBLE-----------------------------------------------------

	@Override
	public Kibble getKibbleById(int kibbleId) {
		
		return kibbleRepo.findById(kibbleId);
	}

//	----ADD KIBBLE -----------------------------------------------------

	@Override
	public Kibble create(Kibble kibble) {
	
		return kibbleRepo.saveAndFlush(kibble);
	
		
	}
//	----UPDATE KIBBLE -----------------------------------------------------

	@Override
	public Kibble update(int kibbleId, Kibble kibble) {
		Kibble existingKibble = kibbleRepo.findById(kibbleId);
		if(existingKibble != null) {
			existingKibble.setName(kibble.getName());
			existingKibble.setCreateDate(kibble.getCreateDate());
			existingKibble.setProtein(kibble.getProtein());
			existingKibble.setKibbleUrl(kibble.getKibbleUrl());
			existingKibble.setResult(kibble.getResult());
			return kibbleRepo.saveAndFlush(existingKibble);
		}
		return null;
	}
//	----DELETE KIBBLE -----------------------------------------------------

	@Override
	public boolean deleteById(int kibbleId) {
		boolean deleted = false;
		Kibble kibbleToDelete = kibbleRepo.findById(kibbleId);
		if(kibbleToDelete != null) {
			kibbleRepo.delete(kibbleToDelete);
			deleted = true;
		}
		return deleted;
	}

}

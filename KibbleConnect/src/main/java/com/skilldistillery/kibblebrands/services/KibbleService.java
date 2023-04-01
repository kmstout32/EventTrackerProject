package com.skilldistillery.kibblebrands.services;

import java.util.List;

import com.skilldistillery.kibblebrands.entities.Kibble;

public interface KibbleService {
 
	List<Kibble> listAll();
	Kibble getKibble(int kibbleId);
	Kibble create(Kibble kibble);
	Kibble update(int kibbleId, Kibble kibble);
	boolean deleteById(int kibbleId);
}

package se.lexicon.maria.aromatime.service;

import java.util.List;

import se.lexicon.maria.aromatime.entity.Oil;


public interface OilService {

	Oil findById(int id);

	List<Oil> findAll();

	List<Oil> findByName(String name);

	boolean removeOil(int id);

	Oil save(Oil oil);
	
	
}

package se.lexicon.maria.aromatime.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.lexicon.maria.aromatime.entity.Oil;


public interface OilRepo extends CrudRepository<Oil, Integer>{
	
	List<Oil> findByOilNameIgnoreCase(String name);
	
}

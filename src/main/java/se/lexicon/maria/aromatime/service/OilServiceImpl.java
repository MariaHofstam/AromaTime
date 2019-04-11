package se.lexicon.maria.aromatime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.repositories.OilRepo;

@Service
@Transactional
public class OilServiceImpl implements OilService{
	
	private OilRepo oilRepo;
	
	@Autowired
	public OilServiceImpl(OilRepo oilRepo) {
		this.oilRepo = oilRepo;
	}
	

	@Override
	public Oil findById(int id) {
		Optional<Oil> result = oilRepo.findById(id);
		return result.orElseThrow(IllegalArgumentException::new);
	}
	
	@Override
	public List<Oil> findAll() {
		return (List<Oil>) oilRepo.findAll();
	}

	@Override
	public List<Oil> findByName(String name) {
		return oilRepo.findByNameIgnoreCase(name);
	}

	@Override
	public boolean removeOil(int id) {
			oilRepo.deleteById(id);		
			return oilRepo.existsById(id);
	}

	@Override
	public Oil save(Oil oil) {
		return oilRepo.save(oil);
	}


}

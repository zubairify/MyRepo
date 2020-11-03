package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Universe;
import com.cg.exception.UniverseNotFoundException;
import com.cg.repository.IUniverseRepository;

@Service
public class UniverseService implements IUniverseService {

	@Autowired
	private IUniverseRepository repo;
	
	@Override
	public void add(Universe universe) {
		repo.save(universe);
	}

	@Override
	public Universe get(int uid) throws UniverseNotFoundException {
		return repo.findById(uid).orElseThrow(() -> new UniverseNotFoundException("Universe not found by Id:" + uid));
	}

	@Override
	public Universe get(String uname) throws UniverseNotFoundException {
		Universe univ = repo.findByName(uname);
		if(univ == null)
			throw new UniverseNotFoundException("Universe not found by name: " + uname);
		return univ;
	}
}

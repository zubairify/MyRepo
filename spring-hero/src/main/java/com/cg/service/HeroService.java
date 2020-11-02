package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hero;
import com.cg.exception.HeroNotFoundException;
import com.cg.exception.UniverseNotFoundException;
import com.cg.repository.IHeroRepository;

@Service
public class HeroService implements IHeroService {
	
	@Autowired
	private IHeroRepository repo;

	@Override
	public void add(Hero hero) {
		repo.save(hero);
	}

	@Override
	public Hero get(int id) throws HeroNotFoundException {
		Hero hero = repo.findById(id).orElseThrow(() -> new HeroNotFoundException("Hero Id doesn't exist: " + id));
		return hero;
	}

	@Override
	public List<Hero> list() {
		return repo.findAll();
	}

	@Override
	public List<Hero> heroesByUniverse(String universe) throws UniverseNotFoundException {
		List<Hero> heroes = repo.findByUniverse(universe);
		if(heroes == null || heroes.size() == 0)
			throw new UniverseNotFoundException(universe + " Universe does not exist");
		return heroes;
	}
}

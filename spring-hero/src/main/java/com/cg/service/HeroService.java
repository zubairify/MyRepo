package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hero;
import com.cg.exception.HeroNotFoundException;
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
		Hero hero = repo.findById(id).orElseThrow(HeroNotFoundException::new);
		return hero;
	}

	@Override
	public List<Hero> list() {
		return repo.findAll();
	}

	@Override
	public List<Hero> heroesByUniverse(String universe) {
		return repo.findByUniverse(universe);
	}
}

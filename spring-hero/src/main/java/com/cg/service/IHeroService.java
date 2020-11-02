package com.cg.service;

import java.util.List;

import com.cg.entity.Hero;
import com.cg.exception.HeroNotFoundException;

public interface IHeroService {
	
	void add(Hero hero);
	
	Hero get(int id) throws HeroNotFoundException;
	
	List<Hero> list();
	
	List<Hero> heroesByUniverse(String universe);
}

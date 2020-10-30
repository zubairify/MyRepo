package com.cg.service;

import java.util.List;

import com.cg.entity.Hero;

public interface IHeroService {
	
	void add(Hero hero);
	
	Hero get(int id);
	
	List<Hero> list();
	
	List<Hero> heroesByUniverse(String universe);
}

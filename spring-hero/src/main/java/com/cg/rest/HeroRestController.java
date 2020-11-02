package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hero;
import com.cg.exception.HeroNotFoundException;
import com.cg.exception.UniverseNotFoundException;
import com.cg.service.IHeroService;

@RestController
public class HeroRestController {

	@Autowired
	private IHeroService service;
	
	// URL: http://localhost:8880/add
	@PostMapping(value = "/add", consumes = "application/json")
	public String addHero(@RequestBody Hero hero){
		service.add(hero);
		return "Hero added to clan";
	}
	
	// URL: http://localhost:8880/get?id=123
	@GetMapping(value = "/get", produces = "application/json")
	public Hero getHero(@RequestParam("id") int id) throws HeroNotFoundException {
		return service.get(id);
	}
	
	// URL: http://localhost:8880/list
	@GetMapping(value = "/list", produces = "application/json")
	public List<Hero> listHeroes() {
		return service.list();
	}
	
	// URL: http://localhost:8880/universe/marvel
	@GetMapping(value = "/universe/{univ}", produces = "application/json")
	public List<Hero> byUniverse(@PathVariable("univ") String universe) throws UniverseNotFoundException {
		return service.heroesByUniverse(universe);
	}
}

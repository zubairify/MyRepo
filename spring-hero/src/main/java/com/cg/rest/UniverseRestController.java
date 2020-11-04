package com.cg.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Universe;
import com.cg.exception.UniverseNotFoundException;
import com.cg.service.IUniverseService;

@RestController
public class UniverseRestController {

	@Autowired
	private IUniverseService service;
	
	@PostMapping(value = "/addu", consumes = "application/json")
	public Universe addUniverse(@RequestBody Universe universe) {
		service.add(universe);
//		return "Universe added successfully";
		return universe;
	}
	
	@GetMapping(value = "/getu", produces = "application/json")
	public Universe getUniverse(@RequestParam("uid") int uid) throws UniverseNotFoundException {
		return service.get(uid);
	}
	
	@GetMapping(value = "/getu/{uname}", produces = "application/json")
	public Universe getUniverse(@PathVariable String uname) throws UniverseNotFoundException {
		return service.get(uname);
	}
}

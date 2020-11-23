package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Album;
import com.cg.service.IAlbumService;

@CrossOrigin
@RestController
public class AlbumRestController {
	
	@Autowired
	private IAlbumService service;
	
	@PostMapping(value = "/add", produces = "application/json")
	public Album addAlbum(@RequestBody Album album) {
		return service.add(album);
	}
	
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public Album getAlbum(@PathVariable int id) {
		return service.get(id);
	}
	
	@GetMapping(value = "/list",  produces = "application/json")
	public List<Album> listAlbum() {
		return service.getAll();
	}
}

package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Album;
import com.cg.repo.AlbumRepository;

@Service
public class AlbumService implements IAlbumService {
	@Autowired
	private AlbumRepository repo;
	
	@Override
	public Album add(Album album) {
		return repo.save(album);
	}

	@Override
	public List<Album> getAll() {
		return repo.findAll();
	}

	@Override
	public Album get(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Album byArtist(String artist) {
		return repo.findByArtist(artist);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
}

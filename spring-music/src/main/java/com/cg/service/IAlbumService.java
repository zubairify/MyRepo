package com.cg.service;

import java.util.List;

import com.cg.entity.Album;

public interface IAlbumService {

	Album add(Album album);
	
	List<Album> getAll();
	
	Album get(int id);
	
	Album byArtist(String artist);
	
	void delete(int id);
}

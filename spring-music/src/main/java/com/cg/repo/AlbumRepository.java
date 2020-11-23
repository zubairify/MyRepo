package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

	Album findByArtist(String artist);

}

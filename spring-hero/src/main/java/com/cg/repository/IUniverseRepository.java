package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Universe;

public interface IUniverseRepository extends JpaRepository<Universe, Integer> {

	@Query("FROM Universe WHERE uname=:name")
	Universe findByName(@Param("name") String uname);
}

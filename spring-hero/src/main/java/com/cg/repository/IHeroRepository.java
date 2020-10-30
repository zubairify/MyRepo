package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Hero;

public interface IHeroRepository extends JpaRepository<Hero, Integer>{

	@Query("FROM Hero WHERE universe=:univ")
	List<Hero> findByUniverse(@Param("univ") String universe);
}

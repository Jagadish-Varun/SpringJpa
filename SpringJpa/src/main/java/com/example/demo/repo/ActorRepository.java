package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
	
	  @Query("SELECT DISTINCT a FROM Actor a " +
	           "JOIN a.filmActors fa " +
	           "JOIN fa.film f " +
	           "JOIN f.language l " +
	           "WHERE LOWER(l.name) = LOWER(:languageName)")
	  List<Actor> findActorsByLanguage(@Param("languageName") String languageName);

}

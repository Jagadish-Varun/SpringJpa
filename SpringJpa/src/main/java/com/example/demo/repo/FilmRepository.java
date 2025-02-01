package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Film;

@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<Film, Integer>{
	
	@Query("SELECT DISTINCT f FROM Film f " +
		       "LEFT JOIN FETCH f.filmCategories fc " +
		       "LEFT JOIN FETCH fc.category c " +
		       "LEFT JOIN FETCH f.filmActors fa " +
		       "LEFT JOIN FETCH fa.actor a " +
		       "LEFT JOIN FETCH f.language lang " +  
		       "LEFT JOIN FETCH f.originalLanguage origLang " +  
		       "WHERE LOWER(c.name) = LOWER(:categoryName)")
	List<Film> findFilmsWithDetails(@Param("categoryName") String categoryName);






}

package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.TopRentedFilmDTO;
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


	 @Query("SELECT new com.example.demo.dto.TopRentedFilmDTO(" +
	           "f.title, COUNT(r.rentalId), COALESCE(SUM(p.amount), 0), cat.name, " +
	           "a.firstName || ' ' || a.lastName) " + 
	           "FROM Rental r " +
	           "JOIN r.inventory i " +
	           "JOIN i.film f " +
	           "JOIN f.filmCategories fc " +
	           "JOIN fc.category cat " +
	           "JOIN f.filmActors fa " + 
	           "JOIN fa.actor a " +
	           "LEFT JOIN r.payments p " +
	           "GROUP BY f.title, cat.name, a.firstName, a.lastName " +
	           "ORDER BY COUNT(r.rentalId) DESC")
	  List<TopRentedFilmDTO> findTopRentedFilms();



}

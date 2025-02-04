package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer>{
	
	  @Query("SELECT c.firstName, c.lastName, f.title, " +
	           "(SELECT GROUP_CONCAT(a.firstName, ' ', a.lastName) FROM FilmActor fa " +
	           " JOIN fa.actor a WHERE fa.film.filmId = f.filmId) AS actorNames, " +
	           "cat.name AS category, p.amount " +
	           "FROM Rental r " +
	           "JOIN r.customer c " +
	           "JOIN r.inventory i " +
	           "JOIN i.film f " +
	           "JOIN f.filmCategories fc " +
	           "JOIN fc.category cat " +
	           "LEFT JOIN r.payments p " +
	           "WHERE c.customerId = :customerId")
	   List<Object[]> findRentalHistoryByCustomerId(@Param("customerId") Integer customerId);

}

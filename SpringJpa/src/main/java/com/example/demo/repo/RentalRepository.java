package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.RentalHistoryDTO;
import com.example.demo.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer>{
	
	@Query("SELECT new com.example.demo.dto.RentalHistoryDTO(" +
	           "c.firstName, c.lastName, f.title, cat.name, COALESCE(p.amount, 0)) " +
	           "FROM Rental r " +
	           "JOIN r.customer c " +
	           "JOIN r.inventory i " +
	           "JOIN i.film f " +
	           "JOIN f.filmCategories fc " +
	           "JOIN fc.category cat " +
	           "LEFT JOIN r.payments p " +
	           "WHERE c.customerId = :customerId " +
	           "ORDER BY f.title ASC")
	 List<RentalHistoryDTO> findRentalHistoryByCustomerId(@Param("customerId") Integer customerId);

}

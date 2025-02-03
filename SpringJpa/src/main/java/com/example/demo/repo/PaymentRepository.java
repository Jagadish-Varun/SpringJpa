package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	@Query("SELECT c.firstName || ' ' || c.lastName, SUM(p.amount), GROUP_CONCAT(DISTINCT f.title) " +
		       "FROM Payment p " +
		       "JOIN p.rental r " +
		       "JOIN r.customer c " +
		       "JOIN r.inventory i " + 
		       "JOIN i.film f " +
		       "JOIN f.language l " +
		       "JOIN f.filmCategories fc " +
		       "JOIN fc.category cat " +
		       "JOIN f.filmActors fa " +
		       "JOIN fa.actor a " +
		       "WHERE LOWER(c.firstName) = LOWER(:customerName) OR LOWER(c.lastName) = LOWER(:customerName) " +
		       "GROUP BY c.firstName, c.lastName")
	List<Object[]> findPaymentsByCustomer(@Param("customerName") String customerName);


}

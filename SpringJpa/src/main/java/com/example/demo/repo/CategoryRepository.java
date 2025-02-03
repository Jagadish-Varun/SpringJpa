package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	 @Query("SELECT DISTINCT c FROM Category c " +
	           "JOIN c.filmCategories fc " +
	           "JOIN fc.film f " +
	           "JOIN f.filmActors fa " +
	           "JOIN fa.actor a " +
	           "WHERE LOWER(a.firstName) = LOWER(:firstName) AND LOWER(a.lastName) = LOWER(:lastName)")
	  List<Category> findCategoriesByActor(@Param("firstName") String firstName, 
	                                       @Param("lastName") String lastName);

}

package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.RentalHistoryDTO;
import com.example.demo.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer>{
	

}

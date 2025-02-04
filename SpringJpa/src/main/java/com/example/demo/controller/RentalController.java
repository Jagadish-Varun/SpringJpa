package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RentalHistoryDTO;
import com.example.demo.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@GetMapping("/history/{customerId}")
	public ResponseEntity<List<RentalHistoryDTO>> getRentalHistory(@PathVariable Integer customerId) {
		List<RentalHistoryDTO> rentalHistory = rentalService.getRentalHistory(customerId);
		return ResponseEntity.ok(rentalHistory);
	}
}

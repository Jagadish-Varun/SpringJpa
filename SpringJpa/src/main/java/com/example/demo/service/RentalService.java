package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RentalHistoryDTO;
import com.example.demo.repo.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	public List<RentalHistoryDTO> getRentalHistory(Integer customerId) {
		return rentalRepository.findRentalHistoryByCustomerId(customerId);
	}
}

package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Rental;
import com.example.demo.repo.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	 
}

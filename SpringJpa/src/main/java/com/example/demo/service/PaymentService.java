package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerPaymentDTO;
import com.example.demo.repo.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public List<CustomerPaymentDTO> getPaymentsByCustomer(String customerName) {
		List<Object[]> results = paymentRepository.findPaymentsByCustomer(customerName);

		return results.stream().map(obj -> new CustomerPaymentDTO((String) obj[0], (BigDecimal) obj[1],
				Arrays.asList(((String) obj[2]).split(",")))).collect(Collectors.toList());
	}

}

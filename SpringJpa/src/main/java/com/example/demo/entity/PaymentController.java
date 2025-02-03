package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerPaymentDTO;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<CustomerPaymentDTO>> getPaymentsByCustomer(@PathVariable String customerName) {
        List<CustomerPaymentDTO> payments = paymentService.getPaymentsByCustomer(customerName);
        return ResponseEntity.ok(payments);
    }
}

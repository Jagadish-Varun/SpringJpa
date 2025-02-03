package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", nullable = false)
	private Integer paymentId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;

	@Column(name = "amount", nullable = false, precision = 5, scale = 2)
	private BigDecimal amount;

	@Column(name = "payment_date", nullable = false)
	private LocalDateTime paymentDate;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}

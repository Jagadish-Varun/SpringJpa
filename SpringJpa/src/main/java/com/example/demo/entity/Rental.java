package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private Integer rentalId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "inventory_id", nullable = false)
	private Inventory inventory; 
	
	@ManyToOne  
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	private Set<Payment> payments;

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	
}

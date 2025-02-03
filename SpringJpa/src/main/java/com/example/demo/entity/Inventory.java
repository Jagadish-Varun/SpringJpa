package com.example.demo.entity;

import java.util.Set;

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
@Table(name = "inventory")
public class Inventory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @OneToMany(mappedBy = "inventory")
    private Set<Rental> rentals; 

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Set<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}  
    
    

   
}

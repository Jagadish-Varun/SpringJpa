package com.example.demo.dto;

import java.math.BigDecimal;

public class TopRentedFilmDTO {

	private String filmTitle;
	private Long rentalCount;
	private BigDecimal totalRevenue;
	private String category;
	private String actorNames;

	public TopRentedFilmDTO(String filmTitle, Long rentalCount, BigDecimal totalRevenue, String category,
			String actorNames) {
		this.filmTitle = filmTitle;
		this.rentalCount = rentalCount;
		this.totalRevenue = totalRevenue;
		this.category = category;
		this.actorNames = actorNames;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public Long getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(Long rentalCount) {
		this.rentalCount = rentalCount;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getActorNames() {
		return actorNames;
	}

	public void setActorNames(String actorNames) {
		this.actorNames = actorNames;
	}

}

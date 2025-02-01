package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.entity.Film;

public class FilmDTO {

	private Integer filmId;
	private String title;
	private String description;
	private Integer releaseYear;
	private String language;
	private BigDecimal rentalRate;
	private String rating;

	public FilmDTO(Film film) {
		if (film != null) {
			this.filmId = film.getFilmId();
			this.title = film.getTitle();
			this.description = film.getDescription();
			this.releaseYear = film.getReleaseYear();
			this.language = (film.getLanguage() != null) ? film.getLanguage().getName() : "Unknown";
			this.rentalRate = film.getRentalRate();
			this.rating = (film.getRating() != null) ? film.getRating().toString() : "Unrated";
		}
	}

	// ✅ Getters & Setters (Required for serialization)
	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}

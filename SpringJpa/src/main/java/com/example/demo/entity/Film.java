package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "film")
@Data
@JsonIgnoreProperties({"filmActors", "filmCategories", "rentals"}) 
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	private Integer filmId;

	@Column(name = "title", nullable = false, length = 128)
	private String title;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "release_year", columnDefinition = "YEAR")
	private Integer releaseYear;

	@ManyToOne(fetch = FetchType.EAGER) // Load immediately instead of Lazy
	@JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
	private Language language;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
	private Language originalLanguage;

	@Column(name = "rental_duration", nullable = false, columnDefinition = "TINYINT UNSIGNED DEFAULT 3")
	private Integer rentalDuration;

	@Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
	private BigDecimal rentalRate;

	@Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
	private Integer length;

	@Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
	private BigDecimal replacementCost;

	@Convert(converter = RatingConverter.class)
	private Rating rating;

	@Column(name = "special_features", columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
	private String specialFeatures;


	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("film")
	private Set<FilmActor> filmActors;

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private Set<FilmCategory> filmCategories; 
	
//	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//	private Set<Rental> rentals;
//	

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

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Set<FilmActor> getFilmActors() {
		return filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public Set<FilmCategory> getFilmCategories() {
		return filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

//	public Set<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(Set<Rental> rentals) {
//		this.rentals = rentals;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

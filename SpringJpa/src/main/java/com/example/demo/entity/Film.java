package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Set;

import com.example.demo.spec.SpecialFeature;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "film_id")
	    private Short filmId;

	    @Column(name = "title", nullable = false, length = 128)
	    private String title;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "release_year")
	    private Integer releaseYear;

	    @ManyToMany
	    @JoinTable(
	    		name = "film_language",
	    		joinColumns = @JoinColumn(name = "film_id"),
	    		inverseJoinColumns = @JoinColumn(name ="language_id")
	    		)
	    private Set<Language> languages;

	    @ManyToOne
	    @JoinColumn(name = "original_language_id")
	    private Language originalLanguage;

	    @Column(name = "rental_duration", nullable = false)
	    private Short rentalDuration = 3;

	    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
	    private BigDecimal rentalRate = new BigDecimal("4.99");

	    @Column(name = "length")
	    private Short length;

	    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
	    private BigDecimal replacementCost = new BigDecimal("19.99");

	   
	    @Column(name = "rating")
	    private String rating;

	    @Enumerated(EnumType.STRING)
	    @CollectionTable(name = "film_special_features", joinColumns = @JoinColumn(name = "film_id"))
	    @Column(name = "special_feature")
	    private Set<SpecialFeature> specialFeatures;

	    @OneToMany(mappedBy = "film")
	    private Set<FilmCategory> filmCategories;

	    @OneToMany(mappedBy = "film")
	    private Set<FilmActor> filmActors;

	    @Column(name = "last_update", nullable = false)
	    private Timestamp lastUpdate;

		public Short getFilmId() {
			return filmId;
		}

		public void setFilmId(Short filmId) {
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

		public Set<Language> getLanguages() {
			return languages;
		}

		public void setLanguages(Set<Language> languages) {
			this.languages = languages;
		}

		public Language getOriginalLanguage() {
			return originalLanguage;
		}

		public void setOriginalLanguage(Language originalLanguage) {
			this.originalLanguage = originalLanguage;
		}

		public Short getRentalDuration() {
			return rentalDuration;
		}

		public void setRentalDuration(Short rentalDuration) {
			this.rentalDuration = rentalDuration;
		}

		public BigDecimal getRentalRate() {
			return rentalRate;
		}

		public void setRentalRate(BigDecimal rentalRate) {
			this.rentalRate = rentalRate;
		}

		public Short getLength() {
			return length;
		}

		public void setLength(Short length) {
			this.length = length;
		}

		public BigDecimal getReplacementCost() {
			return replacementCost;
		}

		public void setReplacementCost(BigDecimal replacementCost) {
			this.replacementCost = replacementCost;
		}

		public String getRating() {
			return rating;
		}

		public void setRating(String rating) {
			this.rating = rating;
		}

		public Set<SpecialFeature> getSpecialFeatures() {
			return specialFeatures;
		}

		public void setSpecialFeatures(Set<SpecialFeature> specialFeatures) {
			this.specialFeatures = specialFeatures;
		}

		public Set<FilmCategory> getFilmCategories() {
			return filmCategories;
		}

		public void setFilmCategories(Set<FilmCategory> filmCategories) {
			this.filmCategories = filmCategories;
		}

		public Set<FilmActor> getFilmActors() {
			return filmActors;
		}

		public void setFilmActors(Set<FilmActor> filmActors) {
			this.filmActors = filmActors;
		}

		public Timestamp getLastUpdate() {
			return lastUpdate;
		}

		public void setLastUpdate(Timestamp lastUpdate) {
			this.lastUpdate = lastUpdate;
		}
	    
	    
}

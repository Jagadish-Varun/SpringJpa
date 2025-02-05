package com.example.demo.dto;

import java.util.List;

public class FilmDetailsDTO {

	private String title;
	private String description;
	private Integer languageId;
	private String specialFeatures;
	private List<String> filmActors;
	private String category;

	public FilmDetailsDTO(String title, String description, Integer languageId, String specialFeatures,
			List<String> filmActors, String category) {
		this.title = title;
		this.description = description;
		this.languageId = languageId;
		this.specialFeatures = specialFeatures;
		this.filmActors = filmActors;
		this.category = category;
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

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<String> getFilmActors() {
		return filmActors;
	}

	public void setFilmActors(List<String> filmActors) {
		this.filmActors = filmActors;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}

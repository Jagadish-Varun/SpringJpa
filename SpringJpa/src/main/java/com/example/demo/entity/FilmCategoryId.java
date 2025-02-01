package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class FilmCategoryId implements Serializable {

	@Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	private Integer filmId;

	@Column(name = "category_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	private Integer categoryId;

}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FilmDetailsDTO;
import com.example.demo.dto.TopRentedFilmDTO;
import com.example.demo.entity.Film;
import com.example.demo.repo.FilmRepository;

import jakarta.persistence.Tuple;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getFilmsWithDetails(String categoryName) {
		Specification<Film> spec = FilmRepository.findFilmsWithDetailsSpec(categoryName);
		return filmRepository.findAll(spec);
	}

	public List<FilmDetailsDTO> getFilmsByYear(Integer releaseYear) {
		Specification<Film> spec = FilmRepository.findFilmsByYear(releaseYear);
		List<Film> films = filmRepository.findAll(spec);

		return films.stream()
				.map(film -> new FilmDetailsDTO(film.getTitle(), film.getDescription(),
						film.getLanguage().getLanguageId(), film.getSpecialFeatures(),
						film.getFilmActors().stream()
								.map(fa -> fa.getActor().getFirstName() + " " + fa.getActor().getLastName())
								.collect(Collectors.toList()),
						film.getFilmCategories().isEmpty() ? "Unknown"
								: film.getFilmCategories().iterator().next().getCategory().getName()))
				.collect(Collectors.toList());
	}

	public List<Film> findFilmsByActor(String firstName, String lastName) {
		Specification<Film> spec = FilmRepository.findByActorName(firstName, lastName);
		return filmRepository.findAll(spec);
	}

}

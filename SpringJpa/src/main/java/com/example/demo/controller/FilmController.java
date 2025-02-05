package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.FilmDetailsDTO;
import com.example.demo.dto.TopRentedFilmDTO;
import com.example.demo.entity.Film;
import com.example.demo.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

	@Autowired
	private FilmService filmService;

//	@GetMapping("/details/{categoryName}")
//	public ResponseEntity<List<FilmDTO>> getFilmsWithDetails(@PathVariable String categoryName) {
//		List<FilmDTO> filmDTOs = filmService.getFilmsWithDetails(categoryName).stream().map(FilmDTO::new)
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(filmDTOs);
//	}

	@GetMapping("/details/{categoryName}")
	public ResponseEntity<List<Film>> getFilmsByCategory(@PathVariable String categoryName) {
		List<Film> films = filmService.getFilmsWithDetails(categoryName);
		return ResponseEntity.ok(films);
	}

	@GetMapping("/top-rented")
	public ResponseEntity<List<TopRentedFilmDTO>> getTopRentedFilms() {
		List<TopRentedFilmDTO> films = filmService.getTopRentedFilms();
		return ResponseEntity.ok(films);
	}

	@GetMapping("/by-year/{releaseYear}")
	public ResponseEntity<List<FilmDetailsDTO>> getFilmsByYear(@PathVariable Integer releaseYear) {
		List<FilmDetailsDTO> films = filmService.getFilmsByYear(releaseYear);
		return ResponseEntity.ok(films);
	}

}

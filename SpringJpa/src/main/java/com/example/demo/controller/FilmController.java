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
import com.example.demo.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

	@Autowired
	private FilmService filmService;


	@GetMapping("/details/{categoryName}")
	public ResponseEntity<List<FilmDTO>> getFilmsWithDetails(@PathVariable String categoryName) {
	    List<FilmDTO> filmDTOs = filmService.getFilmsWithDetails(categoryName)
	                                        .stream()
	                                        .map(FilmDTO::new)  
	                                        .collect(Collectors.toList());

	    return ResponseEntity.ok(filmDTOs);
	}

}

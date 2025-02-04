package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TopRentedFilmDTO;
import com.example.demo.entity.Film;
import com.example.demo.repo.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getFilmsWithDetails(String categoryName) {
		return filmRepository.findFilmsWithDetails(categoryName);
	}

	public List<TopRentedFilmDTO> getTopRentedFilms() {
		return filmRepository.findTopRentedFilms();
	}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Actor;
import com.example.demo.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorService actorService;


	@GetMapping("/by-language/{languageName}")
	public ResponseEntity<List<Actor>> getActorsByLanguage(@PathVariable String languageName) {
		List<Actor> actors = actorService.getActorsByLanguage(languageName);
		return ResponseEntity.ok(actors);
	}

	@GetMapping("/by-language-and-films/{languageName}/{minFilmsActed}")
	public ResponseEntity<List<Actor>> getActorsByLanguageAndMinFilms(@PathVariable String languageName,
			@PathVariable int minFilmsActed) {
		List<Actor> actors = actorService.getActorsByLanguageAndMinFilms(languageName, minFilmsActed);
		return ResponseEntity.ok(actors);
	}
}

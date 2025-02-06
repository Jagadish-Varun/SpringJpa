package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actor;
import com.example.demo.repo.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;

	public List<Actor> getActorsByLanguage(String languageName) {
		Specification<Actor> spec = ActorRepository.findActorsByLanguageSpec(languageName);
		return actorRepository.findAll(spec);
	}

	public List<Actor> getActorsByLanguageAndMinFilms(String languageName, int minFilmsActed) {
		Specification<Actor> spec = ActorRepository.findActorsByLanguageAndMinFilms(languageName, minFilmsActed);
		return actorRepository.findAll(spec);
	}
	
	public List<Actor> findActors(String firstName, String lastName) {
        Specification<Actor> spec = ActorRepository.findByFirstAndLastName(firstName, lastName);
        return actorRepository.findAll(spec);
    }

}

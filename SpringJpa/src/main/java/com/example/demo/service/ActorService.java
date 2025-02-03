package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ActorDTO;
import com.example.demo.entity.Actor;
import com.example.demo.repo.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;

	public List<ActorDTO> getActorsByLanguage(String languageName) {
		List<Actor> actors = actorRepository.findActorsByLanguage(languageName);
		return actors.stream().map(ActorDTO::new).collect(Collectors.toList());
	}

}

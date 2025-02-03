package com.example.demo.dto;

import com.example.demo.entity.Actor;

public class ActorDTO {

	private Integer actorId;
	private String firstName;
	private String lastName;

	public ActorDTO(Actor actor) {
		this.actorId = actor.getActorId();
		this.firstName = actor.getFirstName();
		this.lastName = actor.getLastName();
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}

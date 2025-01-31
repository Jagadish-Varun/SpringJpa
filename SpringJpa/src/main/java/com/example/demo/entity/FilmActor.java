package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_actor")
public class FilmActor {

	@Id
	@ManyToOne
	@JoinColumn(name = "actor_id", nullable = false)
	private Actor actor;

	@Id
	@ManyToOne
	@JoinColumn(name = "film_id", nullable = false)
	private Film film;

	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
}

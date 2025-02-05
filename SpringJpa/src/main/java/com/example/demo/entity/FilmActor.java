package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "film_actor")
@JsonIgnoreProperties({"actor", "film"})
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    @JsonBackReference
    private Actor actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

	public FilmActorId getId() {
		return id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

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




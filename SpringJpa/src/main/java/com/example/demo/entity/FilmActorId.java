package com.example.demo.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class FilmActorId implements java.io.Serializable {
  
	  @Column(name = "actor_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	    private Integer actorId;

	    @Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	    private Integer filmId;

	    // Default constructor
	    public FilmActorId() {}

	    public FilmActorId(Integer actorId, Integer filmId) {
	        this.actorId = actorId;
	        this.filmId = filmId;
	    }

	    // Getters and Setters
	    public Integer getActorId() {
	        return actorId;
	    }

	    public void setActorId(Integer actorId) {
	        this.actorId = actorId;
	    }

	    public Integer getFilmId() {
	        return filmId;
	    }

	    public void setFilmId(Integer filmId) {
	        this.filmId = filmId;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        FilmActorId that = (FilmActorId) o;
	        return Objects.equals(actorId, that.actorId) && Objects.equals(filmId, that.filmId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(actorId, filmId);
	    }
}

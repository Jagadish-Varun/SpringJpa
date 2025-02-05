package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "actor")
@JsonIgnoreProperties({"filmActors"})
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Integer actorId;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<FilmActor> filmActors;

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

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<FilmActor> getFilmActors() {
		return filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}
    
}

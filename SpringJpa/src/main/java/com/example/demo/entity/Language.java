package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Integer languageId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private Set<Film> films;

    @OneToMany(mappedBy = "originalLanguage", cascade = CascadeType.ALL)
    private Set<Film> originalLanguageFilms;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public Set<Film> getOriginalLanguageFilms() {
		return originalLanguageFilms;
	}

	public void setOriginalLanguageFilms(Set<Film> originalLanguageFilms) {
		this.originalLanguageFilms = originalLanguageFilms;
	}
    
    
}


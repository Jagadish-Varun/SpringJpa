package com.example.demo.entity;

import java.security.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int languageId;

	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> originalFilms;

    @ManyToMany(mappedBy = "languages")
    private Set<Film> translatedFilms;

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
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

	public Set<Film> getOriginalFilms() {
		return originalFilms;
	}

	public void setOriginalFilms(Set<Film> originalFilms) {
		this.originalFilms = originalFilms;
	}

	public Set<Film> getTranslatedFilms() {
		return translatedFilms;
	}

	public void setTranslatedFilms(Set<Film> translatedFilms) {
		this.translatedFilms = translatedFilms;
	}
    
    

}

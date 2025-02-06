package com.example.demo.repo;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmActor;
import com.example.demo.entity.Language;

import jakarta.persistence.criteria.*;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {

	public static Specification<Actor> findActorsByLanguageSpec(String languageName) {
		return (Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			query.distinct(true);

			Join<Actor, FilmActor> filmActorJoin = root.join("filmActors", JoinType.INNER);

			Join<FilmActor, Film> filmJoin = filmActorJoin.join("film", JoinType.INNER);

			Join<Film, Language> languageJoin = filmJoin.join("language", JoinType.INNER);

			jakarta.persistence.criteria.Predicate languagePredicate = cb.equal(cb.lower(languageJoin.get("name")),
					languageName.toLowerCase());

			return cb.and(languagePredicate);
		};
	}

	public static Specification<Actor> findActorsByLanguageAndMinFilms(String languageName, int minFilmsActed){
		 return (Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			 query.distinct(true);
			 
			 Join<Actor, FilmActor> filmActorJoin = root.join("filmActors", JoinType.INNER);
			 
			 Join<FilmActor, Film> filmJoin = filmActorJoin.join("film", JoinType.INNER);
			 
			 Join<Film,Language> languageJoin = filmJoin.join("language", JoinType.INNER);
			 
			 jakarta.persistence.criteria.Predicate languagePredicate = cb.equal(cb.lower(languageJoin.get("name")), 
					 languageName.toLowerCase());
			 
			 Expression<Long> filmCount = cb.count(filmJoin.get("filmId"));
			 query.groupBy(root.get("actorId"));
			 
			 jakarta.persistence.criteria.Predicate minFilmsPredicate = cb.ge(filmCount, minFilmsActed);
			 
			 query.having(minFilmsPredicate);
			 query.where(languagePredicate);
			 
			 return cb.and();
		 };
	}
	
}

package com.example.demo.repo;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmActor;
import com.example.demo.entity.Language;

import jakarta.persistence.criteria.*;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {

//	  @Query("SELECT DISTINCT a FROM Actor a " +
//	           "JOIN a.filmActors fa " +
//	           "JOIN fa.film f " +
//	           "JOIN f.language l " +
//	           "WHERE LOWER(l.name) = LOWER(:languageName)")
//	  List<Actor> findActorsByLanguage(@Param("languageName") String languageName);

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

}

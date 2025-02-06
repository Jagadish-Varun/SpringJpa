package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.TopRentedFilmDTO;
import com.example.demo.entity.Actor;
import com.example.demo.entity.Category;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmActor;
import com.example.demo.entity.FilmCategory;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Language;
import com.example.demo.entity.Rental;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film> {


	@SuppressWarnings("unused")
	public static Specification<Film> findFilmsWithDetailsSpec(String categoryName) {
		return (Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			query.distinct(true);

			root.fetch("filmCategories", JoinType.LEFT);
			Join<Film, FilmCategory> filmCategoryJoin = root.join("filmCategories", JoinType.LEFT);
			Join<FilmCategory, Category> categoryJoin = filmCategoryJoin.join("category", JoinType.LEFT);

			root.fetch("filmActors", JoinType.LEFT);
			Join<Film, FilmActor> filmActorJoin = root.join("filmActors", JoinType.LEFT);
			filmActorJoin.join("actor", JoinType.LEFT);

			root.fetch("language", JoinType.LEFT);
			Join<Film, Language> languageJoin = root.join("language", JoinType.LEFT);

			root.fetch("originalLanguage", JoinType.LEFT);
			Join<Film, Language> originalLanguageJoin = root.join("originalLanguage", JoinType.LEFT);

			jakarta.persistence.criteria.Predicate categoryPredicate = cb.equal(cb.lower(categoryJoin.get("name")),
					categoryName.toLowerCase());

			return cb.and(categoryPredicate);
		};
	}
	
	@SuppressWarnings("unused")
	public static Specification<Film> findFilmsByYear(Integer releaseYear){
		return (Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			query.distinct(true);
			
			Join<Film, Language> languageJoin = root.join("language", JoinType.INNER);
			Join<Film, FilmCategory> filmCategoryJoin = root.join("filmCategories", JoinType.LEFT);
			Join<FilmCategory, Category> categoryJoin = filmCategoryJoin.join("category", JoinType.LEFT);
			Join<Film, FilmActor> filmActorJoin = root.join("filmActors", JoinType.LEFT);
			Join<FilmActor, Actor> actorJoin = filmActorJoin.join("actor", JoinType.LEFT);
			
			jakarta.persistence.criteria.Predicate releaseYearPredicate = cb.equal(root.get("releaseYear"), releaseYear);

	         return cb.and(releaseYearPredicate);
		};
	}
	
	public static Specification<Film> findByActorName(String firstName, String lastName) {
        return (root, query, criteriaBuilder) -> {
            Join<Film, FilmActor> filmActorJoin = root.join("filmActors");
            
            Join<FilmActor, Actor> actorJoin = filmActorJoin.join("actor");

            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();
            
            if (firstName != null && !firstName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(actorJoin.get("firstName"), firstName));
            }
            
            if (lastName != null && !lastName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(actorJoin.get("lastName"), lastName));
            }

            return criteriaBuilder.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };
    }
	
}

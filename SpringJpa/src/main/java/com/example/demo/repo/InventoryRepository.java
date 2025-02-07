package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Category;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmActor;
import com.example.demo.entity.FilmCategory;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Language;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Rental;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>, JpaSpecificationExecutor<Inventory> {

	@SuppressWarnings("unused")
	public static Specification<Inventory> findByFilters(String actorFirstName, String categoryName,
			String languageName) {
		return (Root<Inventory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			query.distinct(true);

			Join<Inventory, Film> filmJoin = root.join("film", JoinType.LEFT);

			Join<Film, FilmCategory> filmCategoryJoin = filmJoin.join("filmCategories", JoinType.LEFT);
			Join<FilmCategory, Category> categoryJoin = filmCategoryJoin.join("category", JoinType.LEFT);

			Join<Film, FilmActor> filmActorJoin = filmJoin.join("filmActors", JoinType.LEFT);
			Join<FilmActor, Actor> actorJoin = filmActorJoin.join("actor", JoinType.LEFT);

			Join<Film, Language> languageJoin = filmJoin.join("language", JoinType.LEFT);

			Join<Inventory, Rental> rentalJoin = root.join("rentals", JoinType.LEFT);
			Join<Rental, Payment> paymentJoin = rentalJoin.join("payments", JoinType.LEFT);

			List<Predicate> predicates = new ArrayList<>();

			if (actorFirstName != null && !actorFirstName.isEmpty()) {
				predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(actorJoin.get("firstName")),
						actorFirstName.toLowerCase()));
			}

			if (categoryName != null && !categoryName.isEmpty()) {
				predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(categoryJoin.get("name")),
						categoryName.toLowerCase()));
			}

			if (languageName != null && !languageName.isEmpty()) {
				predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(languageJoin.get("name")),
						languageName.toLowerCase()));
			}

			return predicates.isEmpty() ? criteriaBuilder.conjunction()
					: criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}

package com.example.demo.repo;


import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Category;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Film;
import com.example.demo.entity.FilmCategory;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Rental;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

	
}

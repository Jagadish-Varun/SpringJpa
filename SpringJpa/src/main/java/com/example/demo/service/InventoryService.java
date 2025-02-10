package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inventory;
import com.example.demo.repo.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public List<Inventory> findFilms(String actorFirstName, String categoryName, String languageName) {
		Specification<Inventory> spec = InventoryRepository.findByFilters(actorFirstName, categoryName, languageName);
		return inventoryRepository.findAll(spec);
	}

	public List<Inventory> getFilteredInventories(String filmTitle, String categoryName, String customerLastName) {
		Specification<Inventory> spec = InventoryRepository.findByFilteredInventories(filmTitle, categoryName,
				customerLastName);
		return inventoryRepository.findAll(spec);
	}

	public List<Inventory> getFilteredInventoriesByFilm(String filmTitle, String categoryName, String customerLastName,
			String actorFirstName) {
		Specification<Inventory> spec = InventoryRepository.findByFiltersByFilm(filmTitle, categoryName,
				customerLastName, actorFirstName);

		List<Inventory> results = inventoryRepository.findAll(spec);

		return results;
	}

}

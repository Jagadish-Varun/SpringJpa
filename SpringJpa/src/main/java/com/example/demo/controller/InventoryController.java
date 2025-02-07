package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/{actorFirstName}/{categoryName}/{languageName}")
	public List<Inventory> getFilms(@PathVariable String actorFirstName, @PathVariable String categoryName,
			@PathVariable String languageName) {
		return inventoryService.findFilms(actorFirstName, categoryName, languageName);
	}

}

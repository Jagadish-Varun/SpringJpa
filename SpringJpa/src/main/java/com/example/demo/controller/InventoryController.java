package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/films/{actorFirstName}/{categoryName}/{languageName}")
	public List<Inventory> getFilms(@PathVariable String actorFirstName, @PathVariable String categoryName,
			@PathVariable String languageName) {
		return inventoryService.findFilms(actorFirstName, categoryName, languageName);
	}

	@GetMapping("customer/{filmTitle}/{categoryName}/{customerLastName}")
	public List<Inventory> getInventories(@PathVariable String filmTitle, @PathVariable String categoryName,
			@PathVariable String customerLastName) {
		return inventoryService.getFilteredInventories(filmTitle, categoryName, customerLastName);
	}

	 @GetMapping("/{filmTitle}/{categoryName}/{customerFirstName}/{paymentAmount}")
	    public ResponseEntity<Map<String, Object>> getInventoriesByFilters(
	            @PathVariable String filmTitle,
	            @PathVariable String categoryName,
	            @PathVariable String customerFirstName,
	            @PathVariable BigDecimal paymentAmount) {

	        List<Inventory> results = inventoryService.getFilteredInventoriesByFilters(filmTitle, categoryName, customerFirstName, paymentAmount);

	        Map<String, Object> response = new HashMap<>();
	        response.put("status", results.isEmpty() ? "FNo Data Found" : "Data Retrieved");
	        response.put("count", results.size());
	        response.put("queryParameters", Map.of(
	            "filmTitle", filmTitle,
	            "categoryName", categoryName,
	            "customerFirstName", customerFirstName,
	            "paymentAmount", paymentAmount
	        ));
	        response.put("results", results);

	        return ResponseEntity.ok(response);
	    }
}

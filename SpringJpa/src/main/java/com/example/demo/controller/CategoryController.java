package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/by-actor/{firstName}/{lastName}")
	public ResponseEntity<List<CategoryDTO>> getCategoriesByActor(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<CategoryDTO> categories = categoryService.getCategoriesByActor(firstName, lastName);
		return ResponseEntity.ok(categories);
	}

}

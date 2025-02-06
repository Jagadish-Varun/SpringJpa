package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

  
}

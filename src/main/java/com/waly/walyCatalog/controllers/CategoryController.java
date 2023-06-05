package com.waly.walyCatalog.controllers;

import com.waly.walyCatalog.dto.CategoryDTO;
import com.waly.walyCatalog.entities.Category;
import com.waly.walyCatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}

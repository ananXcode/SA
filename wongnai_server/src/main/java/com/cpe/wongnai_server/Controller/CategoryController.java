package com.cpe.wongnai_server.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.CategoryRepository;
import com.cpe.wongnai_server.entity.Category;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
class RtypeController {
    private CategoryRepository repository;
    public RtypeController(CategoryRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/categories")
    public Collection<Category> Category() {
        return repository.findAll().stream()
            .collect(Collectors.toList());
    }
}
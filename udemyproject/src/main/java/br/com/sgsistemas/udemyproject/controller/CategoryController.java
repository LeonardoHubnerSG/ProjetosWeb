package br.com.sgsistemas.udemyproject.controller;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.service.CategoryService;
import br.com.sgsistemas.udemyproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category){
        category = categoryService.insert(category);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category){
        category = categoryService.update(id, category);
        return ResponseEntity.ok().body(category);
    }
}

package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.CategoryRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory =  categoryRepository.findById(id);
        return optionalCategory.get();
    }

    public Category insert(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, Category category){
        Category entity = categoryRepository.getReferenceById(id);
        updateData(entity, category);
        return categoryRepository.save(entity);
    }

    private void updateData(Category entity, Category category) {
        entity.setName(category.getName());
    }
}

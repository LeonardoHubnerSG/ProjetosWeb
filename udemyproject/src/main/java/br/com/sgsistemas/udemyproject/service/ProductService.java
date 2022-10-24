package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.repository.CategoryRepository;
import br.com.sgsistemas.udemyproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct =  productRepository.findById(id);
        return optionalProduct.get();
    }

    public Product insert(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product product){
        Product entity = productRepository.getReferenceById(id);
        updateData(entity, product);
        return productRepository.save(entity);
    }

    private void updateData(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setImgUrl(product.getImgUrl());
        entity.setCategories(product.getCategories());
    }
}

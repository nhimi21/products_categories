package com.betaplan.himi.proandcatg.services;

import com.betaplan.himi.proandcatg.models.Category;
import com.betaplan.himi.proandcatg.models.Product;
import com.betaplan.himi.proandcatg.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public final ProductService productService;
    public CategoryService(CategoryRepository categoryRepository,ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }
    public void createCategory(Category category){
        categoryRepository.save(category);
    }
    public Category findCategory(Long id){
        return this.categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findCatNotProd(Product product){
        return this.categoryRepository.findByProductsNotContains(product);
    }
    public void addProductToCategory(Product product,Category category){
        List<Product> exProduct = category.getProducts();
        exProduct.add(product);
        this.categoryRepository.save(category);
    }
}

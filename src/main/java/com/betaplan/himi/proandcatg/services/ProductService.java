package com.betaplan.himi.proandcatg.services;

import com.betaplan.himi.proandcatg.models.Category;
import com.betaplan.himi.proandcatg.models.Product;
import com.betaplan.himi.proandcatg.repositories.CategoryRepository;
import com.betaplan.himi.proandcatg.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    public void createProduct(Product product){
        productRepository.save(product);
    }
    public Product findProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> findAllProduct(){
       return productRepository.findAll();
    }

    public List<Product> findProdNotCat(Category category){
        return this.productRepository.findByCategoriesNotContains(category);
    }
    public void addCategoryToProduct(Category category, Product product){
        List<Category> exCategory = product.getCategories();
        exCategory.add(category);
        this.productRepository.save(product);
    }
}

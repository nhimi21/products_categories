package com.betaplan.himi.proandcatg.repositories;

import com.betaplan.himi.proandcatg.models.Category;
import com.betaplan.himi.proandcatg.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();
    List<Product> findByCategoriesNotContains(Category category);
}

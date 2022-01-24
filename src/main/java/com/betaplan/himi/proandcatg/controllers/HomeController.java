package com.betaplan.himi.proandcatg.controllers;

import com.betaplan.himi.proandcatg.models.Category;
import com.betaplan.himi.proandcatg.models.Product;
import com.betaplan.himi.proandcatg.services.CategoryService;
import com.betaplan.himi.proandcatg.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/products/{id}")
    public String showProd(Model model, @PathVariable("id") Long id){
        Product product = this.productService.findProduct(id);
        model.addAttribute("toProd", this.categoryService.findCatNotProd(product));
        model.addAttribute("prod", product);
        return "showProd";
    }
    @PostMapping("/products/{id}")
    public String createShow(@RequestParam("cats") Long id, @PathVariable("id") Long productId){
        Product productToAdd = this.productService.findProduct(productId);
        Category categoryToAdd = this.categoryService.findCategory(id);
        productService.addCategoryToProduct(categoryToAdd, productToAdd);
        return "redirect:/products/{id}";
    }
    @GetMapping("/categories/{id}")
    public String showCategory(Model model, @PathVariable("id") Long id){
        Category category = this.categoryService.findCategory(id);
        model.addAttribute("toCat", this.productService.findProdNotCat(category));
        model.addAttribute("cat", category);
        return "showCat";
    }
    @PostMapping("/categories/{id}")
    public String createShowCat(@RequestParam("prods") Long id, @PathVariable("id") Long categoryId){
        Product productToAdd = this.productService.findProduct(id);
        Category categoryToAdd = this.categoryService.findCategory(categoryId);
        categoryService.addProductToCategory(productToAdd, categoryToAdd);
        return "redirect:/categories/{id}";
    }
}

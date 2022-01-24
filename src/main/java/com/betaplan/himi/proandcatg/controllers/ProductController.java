package com.betaplan.himi.proandcatg.controllers;

import com.betaplan.himi.proandcatg.models.Product;
import com.betaplan.himi.proandcatg.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product/new")
    public String product( Model model){
        model.addAttribute("product", new Product());
        return "product";
    }
    @PostMapping("/product/new")
    public String createProduct(@ModelAttribute("product") Product product,BindingResult result){
       if (result.hasErrors()){
           return "product";
       }
       productService.createProduct(product);
       return "redirect:/";
    }
}

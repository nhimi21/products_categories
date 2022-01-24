package com.betaplan.himi.proandcatg.controllers;

import com.betaplan.himi.proandcatg.models.Category;
import com.betaplan.himi.proandcatg.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/new")
    public String newCategory(Model model){
        model.addAttribute("category", new Category());
        return "category";
    }
    @PostMapping("/category/new")
    public String createCategory(@ModelAttribute("category") Category category, BindingResult result){
        if (result.hasErrors()){
            return "category";
        }
        categoryService.createCategory(category);
        return "redirect:/";
    }
}

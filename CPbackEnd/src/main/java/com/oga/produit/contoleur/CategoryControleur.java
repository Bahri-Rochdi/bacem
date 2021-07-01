package com.oga.produit.contoleur;
import com.oga.produit.entities.Categorie;
import com.oga.produit.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/category")
public class CategoryControleur {
    private CategoryService categoryService;

    CategoryControleur (CategoryService categoryService1){
        this.categoryService = categoryService1;
    }
    @PostMapping("/addCategory")
    public Categorie addCategory(@RequestBody Categorie categorie){
        return categoryService.create(categorie);
    }
    @PutMapping("/updateCategory/{id}")
    public Categorie updateCategory(@RequestBody Categorie categorie, @PathVariable Long id){
        return categoryService.update(categorie, id);
    }
    @DeleteMapping ("/deletCategory/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return categoryService.delete( id);
    }
    @GetMapping("/getCategory/{id}")
    public Categorie getOneCategory(@PathVariable Long id){
        return categoryService.getOne( id);
    }
    @GetMapping("/")
    public List<Categorie> getListCategory(){
        return categoryService.getListCategory();
    }
}

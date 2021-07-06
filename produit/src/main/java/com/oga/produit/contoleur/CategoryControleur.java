package com.oga.produit.contoleur;

import com.oga.produit.entities.Categorie;
import com.oga.produit.services.CategoryService;
import com.oga.produit.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Clock;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryControleur {
    private CategoryService categoryService;
    @Autowired
    CategoryControleur (CategoryService categoryService1){
        this.categoryService = categoryService1;
    }
    @PostMapping("/addCategory")
    public Categorie addCategory(@RequestBody Categorie categorie){
        categorie.setDateCreation(new Timestamp(System.currentTimeMillis()));
        categorie.setDateModif(null);
        System.out.println(categorie.getDateModif());
        return categoryService.create(categorie);
    }
    @PutMapping("/updateCategory/{id}")
    public Categorie updateCategory(@RequestBody Categorie categorie, @PathVariable Long id){
        Categorie category1 = categoryService.getOne(id);
        categorie.setDateCreation(category1.getDateCreation());
        categorie.setDateModif(new Timestamp(System.currentTimeMillis()));
        return categoryService.update(categorie, id);
    }
    @DeleteMapping ("/deleteCategory/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return categoryService.delete(id);
    }
    @GetMapping("/getCategory/{id}")
    public Categorie getOneCategory(@PathVariable Long id){
        return categoryService.getOne( id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public List<Categorie> getListCategory(){
        return categoryService.getListCategory();
    }

}

package com.oga.produit.contoleur;

import com.oga.produit.entities.Categorie;
import com.oga.produit.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryControleurTest {
@Autowired
private CategoryService categoryService;


    @Test
    void addCategory() {
        Categorie c = new Categorie( null, "cat1" , 10 , new Timestamp(System.currentTimeMillis()), null, null);
        categoryService.create(c);
    }

    @Test
    void updateCategory() {
        Categorie c = new Categorie(null, "cat3" , 10 , new Timestamp(System.currentTimeMillis()), null, null);
        categoryService.create(c);
        c.setNom("cat2");
        c.setId(5L);
        categoryService.update(c, c.getId());
    }

    @Test
    void deleteCategory() {
        Categorie c = new Categorie(null, "cat8" , 10 , new Timestamp(System.currentTimeMillis()), null, null);
        categoryService.create(c);
        categoryService.delete(6L);
    }

    @Test
    void getOneCategory() {
       categoryService.getOne(2L);
    }

    @Test
    void getListCategory() {
       categoryService.getListCategory();
    }
}
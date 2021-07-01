package com.oga.produit.services.impl;

import com.oga.produit.entities.Categorie;
import com.oga.produit.repositories.CategoryRepository;
import com.oga.produit.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository catRep1;
    CategoryServiceImpl (CategoryRepository catRep){
      this.catRep1=catRep;
    }
    @Override
    public Categorie create(Categorie cat) {
        return catRep1.save(cat);
    }

    @Override
    public Categorie update(Categorie categorie, Long id) {
       // Categorie c = catRep1.findById(id).get();
        if(!catRep1.findById(id).isPresent()){
           System.out.println("Category not exist !");
        }
            categorie.setId(id);
            return catRep1.save(categorie);

    }

    @Override
    public Boolean delete(Long id) {
        if(!catRep1.findById(id).isPresent()){
            System.out.println("Category not exist !");
        }
        catRep1.deleteById(id);
        return true;
    }

    @Override
    public Categorie getOne(Long id) {
        if(!catRep1.findById(id).isPresent()){
            System.out.println("Category not exist !");
        }
        return catRep1.findById(id).get();
    }

    @Override
    public List<Categorie> getListCategory() {
        return catRep1.findAll();
    }
}

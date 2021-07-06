package com.oga.produit.contoleur;

import com.oga.produit.entities.Categorie;
import com.oga.produit.entities.Produit;
import com.oga.produit.services.CategoryService;
import com.oga.produit.services.ProduitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produit")
public class ProduitControleur {
    private ProduitService produitService;
    private CategoryService categoryService;

    ProduitControleur (ProduitService produitService1, CategoryService categoryService1){
        this.categoryService = categoryService1;
        this.produitService=produitService1;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addProduit/{id}")
    public Produit addProduct(@RequestBody Produit produit, @PathVariable ("id") Long id){
        if (produit.getQte() > 0 ){
            produit.setDisponible(true);
        }
        else {
            produit.setDisponible(false);
        }
        produit.setDateCreation(new Timestamp(System.currentTimeMillis()));
        produit.setDateModif(null);
        Categorie c = categoryService.getOne(id);
        produit.setCategories(c);
        return produitService.createProd(produit);
    }

    @PutMapping("/updateProduit/{id}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long id){
        Produit produit1 = produitService.getOneProd(id);
        if (produit.getQte() > 0 ){
            produit.setDisponible(true);
        }
        else {
            produit.setDisponible(false);
        }
        produit.setDateCreation(produit1.getDateCreation());
        produit.setDateModif(new Timestamp(System.currentTimeMillis()) );
        return produitService.updateProd(produit, id);
    }

    @DeleteMapping ("/deletProduit/{id}")
    public Boolean deleteProduit(@PathVariable Long id){
        return produitService.deleteProd(id);
    }
    @GetMapping("/getProduit/{id}")
    public Produit getOneProduct(@PathVariable Long id){
        return produitService.getOneProd(id);
    }

    @GetMapping("/")
    public List<Produit> getListProduct(){
        return produitService.getListProduct();
    }



    @PutMapping ("/{idProduit}/addCateoryToProduit/{idCategory}")
    public Produit addCategoryToProduit(@PathVariable Long idProduit, @PathVariable Long idCategory){
        return produitService.addCategoryToProduit(idProduit,idCategory);
    }





    @GetMapping(value="/listProdByCategory/{catId}")
    @ResponseBody
    public List<Produit> getProduitsByCategory(@PathVariable("catId")Long catId) {
        return produitService.getProduitsByCategory(catId);
    }

}

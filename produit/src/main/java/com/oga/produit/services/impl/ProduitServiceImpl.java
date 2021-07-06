package com.oga.produit.services.impl;

import com.oga.produit.entities.Categorie;
import com.oga.produit.entities.Produit;
import com.oga.produit.repositories.CategoryRepository;
import com.oga.produit.repositories.ProduitRepository;
import com.oga.produit.services.ProduitService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Component
public class ProduitServiceImpl implements ProduitService {
    @PersistenceContext
    private EntityManager entityManager;
    private CategoryRepository catRep1;
    private ProduitRepository prodRep1;
    ProduitServiceImpl (ProduitRepository proRep, CategoryRepository catRep){
        this.prodRep1=proRep;
        this.catRep1=catRep;
    }

    @Override
    public Produit createProd(Produit prod) {
        return prodRep1.save(prod);
    }

    @Override
    public Produit updateProd(Produit produit, Long id) {
        if(!prodRep1.findById(id).isPresent()){
            System.out.println("Product not exist !");
        }
        produit.setId(id);
        return prodRep1.save(produit);

    }

    @Override
    public Boolean deleteProd(Long id) {
        if(!prodRep1.findById(id).isPresent()){
            System.out.println("Product not exist !");
        }
        prodRep1.deleteById(id);
        return true;
    }

    @Override
    public Produit getOneProd(Long id) {
        if(!prodRep1.findById(id).isPresent()){
            System.out.println("Product not exist !");
        }
        return prodRep1.findById(id).get();
    }

    @Override
    public List<Produit> getListProduct() {
        return prodRep1.findAll();
    }



    @Override
    public Produit addCategoryToProduit(Long idProduit, Long idCategory) {
    Categorie categorie = catRep1.getOne(idCategory);
    Produit produit = prodRep1.getOne(idProduit);
    produit.setCategories(categorie);
    return prodRep1.save(produit);
    }

    @Override
    public List <Produit> getProduitsByCategory (Long catId)
    {
        return  (List<Produit>) prodRep1.getProduitsByCategory(catId) ;
    }

}

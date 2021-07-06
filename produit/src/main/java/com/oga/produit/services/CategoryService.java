package com.oga.produit.services;

import com.oga.produit.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Categorie create(Categorie cat);
    Categorie update(Categorie categorie, Long id);
    Boolean delete(Long id);
    Categorie getOne (Long id);
    List<Categorie> getListCategory ();

}

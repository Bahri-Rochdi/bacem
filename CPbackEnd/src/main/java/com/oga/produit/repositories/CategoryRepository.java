package com.oga.produit.repositories;

import com.oga.produit.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Categorie, Long> {
}

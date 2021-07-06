package com.oga.produit.repositories;

import com.oga.produit.entities.Categorie;
import com.oga.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {



   @Query("select DISTINCT e from Produit e " + "join e.categories m " + "where m.id=:idCategorie")
   List <Produit> getProduitsByCategory(@Param("idCategorie")long idCategorie);
}

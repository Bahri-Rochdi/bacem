package com.oga.produit.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private float qte;
    @CreationTimestamp
    @Column(name = "dateCreation", nullable = false)
    private Timestamp dateCreation;
    @CreationTimestamp
    @Column(name = "dateModif", nullable = false)
    private Timestamp dateModif;

    @OneToMany(mappedBy = "categories")
    private List<Produit> produits ;


}

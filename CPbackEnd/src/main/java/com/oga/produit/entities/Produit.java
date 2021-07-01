package com.oga.produit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import com.oga.produit.entities.*;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private float qte;
    private Boolean disponible;
    @CreationTimestamp
    @Column(name = "dateCreation", nullable = false)
    private Timestamp dateCreation;
    @CreationTimestamp
    @Column(name = "dateModif", nullable = false)
    private Timestamp dateModif;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categories ;

}

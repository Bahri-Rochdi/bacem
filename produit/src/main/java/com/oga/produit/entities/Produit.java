package com.oga.produit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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
    @Column(name = "dateCreation", nullable = true)
    private Timestamp dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateModif", nullable = true)
    private Date dateModif;

    @ManyToOne
    private Categorie categories ;

}

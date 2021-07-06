package com.oga.produit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
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
    @Column(name = "dateCreation", nullable = true)
    private Timestamp dateCreation;

    @Column(name = "dateModif")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    @JsonIgnore
    @OneToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Produit> produits ;


}

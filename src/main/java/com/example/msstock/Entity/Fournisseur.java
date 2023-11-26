package com.example.msstock.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fournisseur implements Serializable {
    private static final long serialversionUID=6;
    @Id
    @GeneratedValue
    private int idFournisseur;
    private String nomFournisseur;
    private String numTel;
    private String productCategorie;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false,updatable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

}

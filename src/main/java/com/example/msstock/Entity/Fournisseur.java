package com.example.msstock.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false,updatable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.ALL)
    private List<Stock> stocks = new ArrayList<>();

}

package com.example.msstock.Service;

import com.example.msstock.Entity.Fournisseur;
import com.example.msstock.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public Fournisseur AddFournisseur(Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }
    public String deleteFournisseur(int id){
        if(fournisseurRepository.findById(id).isPresent()){
            fournisseurRepository.deleteById(id);
            return "Supplier deleted";
        }else {
            return "no Supplier found with that id !!";
        }
    }
    public List<Fournisseur> getFournisseurs(){
        return fournisseurRepository.findAll();
    }
    public Fournisseur updateFournisseur(int id, Fournisseur fournisseur){
        if(fournisseurRepository.findById(id).isPresent()){
            Fournisseur oldFournisseur= fournisseurRepository.findById(id).get();
            oldFournisseur.setNomFournisseur(fournisseur.getNomFournisseur());
            oldFournisseur.setNumTel(fournisseur.getNumTel());
            oldFournisseur.setProductCategorie(fournisseur.getProductCategorie());
            oldFournisseur.setUpdatedAt(new Date());
            return fournisseurRepository.save(oldFournisseur);
        }
        return null;
    }
}

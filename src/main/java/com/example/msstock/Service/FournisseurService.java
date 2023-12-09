package com.example.msstock.Service;

import com.example.msstock.Entity.Fournisseur;
import com.example.msstock.Entity.Stock;
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

        for(Stock stock: fournisseur.getStocks()){
            stock.setFournisseur(fournisseur);
            stock.setCreatedAt(new Date());
            stock.setUpdatedAt(new Date());
        }
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
            oldFournisseur.setEmail(fournisseur.getEmail());
            oldFournisseur.setUpdatedAt(new Date());
            return fournisseurRepository.save(oldFournisseur);
        }
        return null;
    }
}

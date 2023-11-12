package com.example.msstock.Controller;

import com.example.msstock.Entity.Fournisseur;
import com.example.msstock.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Fournisseur")
public class FournisseurControllerRestAPI {
    @Autowired
    private FournisseurService fournisseurService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("addFournisseur")
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur){
        fournisseur.setCreatedAt(new Date());
        fournisseur.setUpdatedAt(new Date());
        return new ResponseEntity<>(fournisseurService.AddFournisseur(fournisseur),HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("deleteFournisseur/{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(fournisseurService.deleteFournisseur(id),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("getFournisseurs")
    public ResponseEntity<List<Fournisseur>> getFournisseur(){
        return new ResponseEntity<>(fournisseurService.getFournisseurs(),HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("updateFournisseur/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") int id,@RequestBody Fournisseur fournisseur){
        return new ResponseEntity<>(fournisseurService.updateFournisseur(id,fournisseur),HttpStatus.OK);
    }

}

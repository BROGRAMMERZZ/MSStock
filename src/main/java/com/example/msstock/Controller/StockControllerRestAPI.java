package com.example.msstock.Controller;

import com.example.msstock.Entity.Fournisseur;
import com.example.msstock.Entity.Stock;
import com.example.msstock.Repository.FournisseurRepository;
import com.example.msstock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("stock")
@CrossOrigin(origins = "*")

public class StockControllerRestAPI {
    @Autowired
    private StockService stockService;
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @PostMapping("addStock/{id}")
    public Stock createStock(@RequestBody Stock stock,@PathVariable("id") int id){
        Fournisseur fournisseur=fournisseurRepository.getById(id);
        stock.setFournisseur(fournisseur);
        stock.setCreatedAt(new Date());
        stock.setUpdatedAt(new Date());
        return stockService.AddStock(stock);
    }

    @DeleteMapping("deleteStock/{id}")
    public void deleteStock(@PathVariable(value = "id") int id){
        stockService.deleteStock(id);
    }

    @GetMapping("getStocks/{id}")
    public List<Stock> getStocks(@PathVariable(value = "id") int id){
        return stockService.getStocks(id);
    }

    @PutMapping("updateStock/{id}")
    public Stock updateStock(@PathVariable(value = "id") int id,@RequestBody Stock stock){
        return stockService.updateStock(id,stock);
    }


}

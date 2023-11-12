package com.example.msstock.Controller;

import com.example.msstock.Entity.Stock;
import com.example.msstock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("stock")
public class StockControllerRestAPI {
    @Autowired
    private StockService stockService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("addStock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
        stock.setCreatedAt(new Date());
        stock.setUpdatedAt(new Date());
        return new ResponseEntity<>(stockService.AddStock(stock),HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("deleteStock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(stockService.deleteStock(id),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("getStocks")
    public ResponseEntity<List<Stock>> getStocks(){
        return new ResponseEntity<>(stockService.getStocks(),HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("updateStock/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable(value = "id") int id,@RequestBody Stock stock){
        return new ResponseEntity<>(stockService.updateStock(id,stock),HttpStatus.OK);
    }


}

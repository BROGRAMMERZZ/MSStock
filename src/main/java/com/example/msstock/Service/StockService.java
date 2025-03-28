package com.example.msstock.Service;

import com.example.msstock.Entity.Stock;
import com.example.msstock.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock AddStock(Stock stock){

        return stockRepository.save(stock);
    }
    public String deleteStock(int id){
        if(stockRepository.findById(id).isPresent()){
            stockRepository.deleteById(id);
            return "Stock deleted";
        }else {
            return "no stock found with that id !!";
        }

    }
    public List<Stock> getStocks(int id) {
        List<Stock> stocks = new ArrayList<>();

        for (Stock stock : stockRepository.findAll()) {
            if (stock.getFournisseur().getIdFournisseur() == id) {
                stocks.add(stock);
            }
        }

        return stocks;
    }


    public Stock updateStock(int id, Stock stock){
        if(stockRepository.findById(id).isPresent()){
            Stock oldStock= stockRepository.findById(id).get();
            oldStock.setQuantity(stock.getQuantity());
            oldStock.setProductName(stock.getProductName());
            oldStock.setPrice(stock.getPrice());
            oldStock.setStatus(stock.getStatus());
            oldStock.setUpdatedAt(new Date());
            return stockRepository.save(oldStock);
        }
        return null;
    }
}

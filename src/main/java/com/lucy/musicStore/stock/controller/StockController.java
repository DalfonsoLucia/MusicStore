package com.lucy.musicStore.stock.controller;

import com.lucy.musicStore.exception.NoStockIdFoundException;
import com.lucy.musicStore.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("id/{id}/{orderReceved}")
    @ResponseStatus(HttpStatus.OK)
    public Integer updateAmountStock(@PathVariable Integer id, @PathVariable Boolean orderReceved) throws NoStockIdFoundException {
        return stockService.updateAmountStock(id, orderReceved);
    }
}

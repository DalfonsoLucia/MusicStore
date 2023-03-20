package com.lucy.musicStore.sale.controller;

import com.lucy.musicStore.exception.NoSaleIdFoundException;
import com.lucy.musicStore.sale.data.model.Sale;
import com.lucy.musicStore.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sale findById(@PathVariable Integer id) throws NoSaleIdFoundException {
        return saleService.findById(id);
    }

    @DeleteMapping("deleteSale/{id}")
    public ResponseEntity deleteCart(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return new ResponseEntity<> ("selected sale successfully deleted", HttpStatus.OK);
    }

    @GetMapping("total/{idCart}")
    @ResponseStatus(HttpStatus.OK)
    public Sale calculateFinalPrice(@PathVariable Integer idCart) {
        return saleService.calculateFinalPrice(idCart);
    }
}

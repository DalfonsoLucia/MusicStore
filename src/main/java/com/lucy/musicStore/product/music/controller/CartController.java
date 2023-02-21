package com.lucy.musicStore.product.music.controller;

import com.lucy.musicStore.product.music.data.dto.CartDTO;
import com.lucy.musicStore.product.music.exception.*;
import com.lucy.musicStore.product.music.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> getAllCarts() throws NoSaleContentException {
        return cartService.findAllCart();
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDTO findById(@PathVariable Integer id) {
        return cartService.findById(id);
    }

    @GetMapping("{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> findByArtist(@PathVariable String artist) throws NoArtistFoundException {
        return cartService.findByArtistSold(artist);
    }

    @GetMapping("title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> findByTitle(@PathVariable String title) throws NoTitleFoundException {
        return cartService.findByTitleSold(title);
    }

    /*
    @GetMapping("sale/{sale}")
    @ResponseStatus(HttpStatus.OK)
    public List<SaleDTO> calcolateTotalPriceSold(@PathVariable Double price) throws NoPriceFoundException {
        return saleService.findTotalPrice(price);
    }
     */

}


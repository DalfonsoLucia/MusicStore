package com.lucy.musicStore.cart.controller;

import com.lucy.musicStore.cart.data.model.Cart;
import com.lucy.musicStore.cart.service.CartService;
import com.lucy.musicStore.cart.dto.CartDTO;
import com.lucy.musicStore.exception.NoArtistFoundException;
import com.lucy.musicStore.exception.NoCartIdFoundException;
import com.lucy.musicStore.exception.NoTitleFoundException;
import com.lucy.musicStore.product.music.data.dto.MusicDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> getAllCarts() throws NoCartIdFoundException {
        return cartService.findAllCart();
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDTO findById(@PathVariable Integer id) throws NoCartIdFoundException {
        return cartService.findById(id);
    }

    @GetMapping("artist/{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> findByArtist(@PathVariable String artist) throws NoArtistFoundException {
        return cartService.findByArtistSold(artist);
    }

    @GetMapping("title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDTO> findByTitle(@PathVariable String title) throws NoTitleFoundException {
        return cartService.findByTitleSold(title);
    }

    @PostMapping("subtotal")
    @ResponseStatus(HttpStatus.OK)
    public Cart calculateSubtotal(@RequestBody List<MusicDetailDTO> musicDetailDTOS) throws ParseException {
        return cartService.calculateSubtotal(musicDetailDTOS);
    }
}




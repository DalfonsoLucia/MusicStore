package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.CartDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFoundException;
import com.lucy.musicStore.product.music.exception.NoSaleContentException;
import com.lucy.musicStore.product.music.exception.NoTitleFoundException;

import java.util.List;

public interface CartService {

    List<CartDTO> findAllCart() throws NoSaleContentException;

    CartDTO findById(Integer id);
    List<CartDTO> findByArtistSold(String artist) throws NoArtistFoundException;
    List<CartDTO> findByTitleSold(String title) throws NoTitleFoundException;
    void save(CartDTO cartDTO);
    //List<CartDTO> calcolateTotalPriceSold(Double price);
    //List<SaleDTO> findByTotalPrice(Double price);
}


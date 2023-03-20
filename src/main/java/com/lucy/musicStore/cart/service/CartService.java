package com.lucy.musicStore.cart.service;

import com.lucy.musicStore.cart.data.model.Cart;
import com.lucy.musicStore.cart.dto.CartDTO;
import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.dto.MusicDetailDTO;

import java.text.ParseException;
import java.util.List;

public interface CartService {

    List<CartDTO> findAllCart() throws NoCartIdFoundException;

    CartDTO findById(Integer id) throws NoCartIdFoundException;
    List<CartDTO> findByArtistSold(String artist) throws NoArtistFoundException;
    List<CartDTO> findByTitleSold(String title) throws NoTitleFoundException;
    void save(CartDTO cartDTO);

    Cart calculateSubtotal(List<MusicDetailDTO> musicDetailDTOS, List<GadgetDTO> gadgetList) throws ParseException;

    void deleteCart(Integer id);
}


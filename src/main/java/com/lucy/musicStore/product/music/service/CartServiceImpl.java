package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.CartDTO;
import com.lucy.musicStore.product.music.data.model.Cart;
import com.lucy.musicStore.product.music.data.model.Sale;
import com.lucy.musicStore.product.music.exception.NoArtistFoundException;
import com.lucy.musicStore.product.music.exception.NoSaleContentException;
import com.lucy.musicStore.product.music.exception.NoTitleFoundException;
import com.lucy.musicStore.product.music.mapper.CartMapper;
import com.lucy.musicStore.product.music.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartMapper cartMapper;


    @Override
    public List<CartDTO> findAllCart() throws NoSaleContentException {
        return this.cartRepository.findAll().stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoSaleContentException::new);
    }

    @Override
    public CartDTO findById(Integer id) {
        return cartMapper.cartToCartDTO(cartRepository.findById(id).get());
    }

    @Override
    public List<CartDTO> findByArtistSold(String artist) throws NoArtistFoundException {
        return this.cartRepository.findByArtist(artist).stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFoundException::new);
    }

    @Override
    public List<CartDTO> findByTitleSold(String title) throws NoTitleFoundException {
        return this.cartRepository.findByTitle(title).stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoTitleFoundException::new);
    }

    @Override
    public void save(CartDTO cartDTO) {
        cartRepository.save(cartMapper.cartDTOToCart(cartDTO));
    }

    /*
    //da implementare
    @Override
    public List<CartDTO> calcolateTotalPriceSold(Double price) {
    List<Cart> soldProdList = new ArrayList<>();

        return null;
    }
     */

    /*
    @Override
    public List<SaleDTO> findByTotalPrice(Double price) {
        return null;
    }

     */
    }


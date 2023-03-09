package com.lucy.musicStore.cart.service;

import com.lucy.musicStore.cart.data.model.Cart;
import com.lucy.musicStore.cart.data.model.CartDetail;
import com.lucy.musicStore.cart.dto.CartDTO;
import com.lucy.musicStore.cart.mapper.CartDetailMapper;
import com.lucy.musicStore.cart.mapper.CartMapper;
import com.lucy.musicStore.cart.repository.CartRepository;
import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.dto.MusicDetailDTO;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.mapper.GadgetMapper;
import com.lucy.musicStore.product.music.repository.AlbumRepository;
import com.lucy.musicStore.product.music.repository.GadgetRepository;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartDetailMapper cartDetailMapper;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SingleRepository singleRepository;

    @Autowired
    GadgetMapper gadgetMapper;

    @Autowired
    GadgetRepository gadgetRepository;


    @Override
    public List<CartDTO> findAllCart() throws NoCartIdFoundException {
        return this.cartRepository.findAll().stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoCartIdFoundException::new);
    }

    @Override
    public CartDTO findById(Integer id) throws NoCartIdFoundException {
        return cartMapper.cartToCartDTO(cartRepository.findById(id).orElseThrow(NoCartIdFoundException::new));
    }

    @Override
    public List<CartDTO> findByArtistSold(String artist) throws NoArtistFoundException {
        /*return this.cartRepository.findByArtist(artist).stream()
                .map(cartDetail -> cartDetailMapper.cartDetailToCartDetailDTO(cartDetail))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFoundException::new);*/
        return this.cartRepository.findByArtist(artist).stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFoundException::new);
    }

    @Override
    public List<CartDTO> findByTitleSold(String title) throws NoTitleFoundException {
        /*return this.cartRepository.findByTitle(title).stream()
                .map(cartDetail -> cartDetailMapper.cartDetailToCartDetailDTO(cartDetail))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoTitleFoundException::new);*/
        return this.cartRepository.findByTitle(title).stream()
                .map(cart -> cartMapper.cartToCartDTO(cart))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoTitleFoundException::new);
    }

    @Override
    public void save(CartDTO cartDTO) {
        cartRepository.save(cartMapper.cartDTOToCart(cartDTO));
    }


    @Override
    public Cart calculateSubtotal(List<MusicDetailDTO> musicDetailDTOS, List<GadgetDTO> gadgetList) throws ParseException {
        Double subtotalCart = 0.0;
        Double amountCart = 0.0;
        List<CartDetail> cartDetailList = new ArrayList<>();
        List<Gadget> gadgets = new ArrayList<>();
        for (MusicDetailDTO prod : musicDetailDTOS) {
            amountCart += prod.getQuantity();
            CartDetail cartDetail = new CartDetail();
            if (prod.getType().equals("Album")) {
                Album albumSave = albumRepository.findById(prod.getId()).get();
                subtotalCart += Math.round(prod.getQuantity() * albumSave.getPrice());
                cartDetail.setId(albumSave.getId());
                cartDetail.setArtist(albumSave.getArtist());
                cartDetail.setTitle(albumSave.getTitle());
                cartDetail.setGenre(albumSave.getGenre());
                cartDetail.setType(albumSave.getType());
                cartDetailList.add(cartDetail);
            } else {
                Single singleSave = singleRepository.findById(prod.getId()).get();
                subtotalCart += prod.getQuantity() * singleSave.getPrice();
                cartDetail.setId(singleSave.getId());
                cartDetail.setArtist(singleSave.getArtist());
                cartDetail.setTitle(singleSave.getTitle());
                cartDetail.setGenre(singleSave.getGenre());
                cartDetail.setType(singleSave.getType());
                cartDetailList.add(cartDetail);
            }
        }
        for (GadgetDTO gad : gadgetList) {
            Gadget gadgetSave = gadgetRepository.findById(gad.getId()).get();
            subtotalCart += Math.round(gadgetSave.getPrice() * gad.getQuantity());
            gadgets.add(gadgetSave);
        }
        /*SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = isoFormat.parse(new Date());*/
        Date date = new Date();
        date.setHours(date.getHours()+1);
        Cart cart = new Cart();
        cart.setAmountPurchased(amountCart);
        cart.setSubtotal(subtotalCart);
        cart.setInsertCartsDate(date);
        cart.setCartDetails(cartDetailList);
        cart.setGadgets(gadgets);
        cartRepository.save(cart);
        return cart;
    }
}



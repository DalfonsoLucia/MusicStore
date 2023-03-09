package com.lucy.musicStore.sale.service;

import com.lucy.musicStore.cart.data.model.Cart;
import com.lucy.musicStore.cart.data.model.CartDetail;
import com.lucy.musicStore.cart.repository.CartRepository;
import com.lucy.musicStore.exception.NoSaleIdFoundException;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.repository.AlbumRepository;
import com.lucy.musicStore.product.music.repository.GadgetRepository;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import com.lucy.musicStore.sale.data.model.Sale;
import com.lucy.musicStore.sale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SingleRepository singleRepository;

    @Autowired
    GadgetRepository gadgetRepository;

    @Override
    public Sale findById(Integer id) throws NoSaleIdFoundException {
        return this.saleRepository.findById(id).orElseThrow(NoSaleIdFoundException::new
        );
    }

    @Override
    public Sale calculateFinalPrice(Integer idCart) {
        Date dateSale = new Date();
        dateSale.setHours(dateSale.getHours()+1);
        Sale sale = new Sale();
        Cart cart = cartRepository.findById(idCart).get();
        sale.setInsertSalesDate(dateSale);
        sale.setItemNumber(cart.getAmountPurchased().intValue());
        sale.setTotalPrice(cart.getSubtotal());
        sale.setSold(true);
        sale.setCart(cart);

        cart.getCartDetails().forEach(this::updateStock);
        cart.getGadgets().forEach(this::updateStockGadget);
        saleRepository.save(sale);
        return sale;
    }

    public void updateStock(CartDetail cartDetail) {
        if (cartDetail.getType().equals("Album")) {
            Album album = albumRepository.findById(cartDetail.getId()).get();
            album.setAmountStock(album.getAmountStock() - cartDetail.getQuantity());
        } else {
            Single single = singleRepository.findById(cartDetail.getId()).get();
            single.setAmountStock(single.getAmountStock() - cartDetail.getQuantity());
        }
    }

    public void updateStockGadget(Gadget gadget) {
        Gadget gadgetStock = gadgetRepository.findById(gadget.getId()).get();
        gadgetStock.setAmountStockGadget(gadgetStock.getAmountStockGadget() - gadget.getQuantity());
    }
}

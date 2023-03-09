package com.lucy.musicStore.stock.service;

import com.lucy.musicStore.exception.NoStockIdFoundException;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.ordination.repository.OrdinationRepository;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.data.model.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    OrdinationRepository ordinationRepository;

    @Override
    public Integer updateAmountStock(Integer id, Boolean orderReceved) throws NoStockIdFoundException{

        Ordination order = ordinationRepository.findById(id).orElseThrow(NoStockIdFoundException::new);
        if (orderReceved) {
            for (Album al : order.getAlbums()) {
                al.setAmountStock(al.getQuantity().doubleValue());
                al.setQuantity(0);
            }
            for (Single sin : order.getSingles()) {
                sin.setAmountStock(sin.getQuantity().doubleValue());
                sin.setQuantity(0);
            }
            for (Gadget gad : order.getGadgets()) {
                gad.setAmountStockGadget(gad.getQuantity().doubleValue());
                gad.setQuantity(0);
            }
        }
        ordinationRepository.save(order);
        return 1;
    }
}


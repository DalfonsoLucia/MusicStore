package com.lucy.musicStore.ordination.service;

import com.lucy.musicStore.exception.NoStockIdFoundException;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;

import java.util.Date;

public interface OrdinationService {

    Ordination createOrder(OrdinationDTO ordinationDTO);
    Ordination findById(Integer id) throws NoStockIdFoundException;
    Ordination findByAlbum(Album album);
    Ordination findBySingle(Single single);
    Ordination findByOrderDate(Date insertOrdinationDate);
}

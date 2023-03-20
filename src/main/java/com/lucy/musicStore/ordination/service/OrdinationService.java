package com.lucy.musicStore.ordination.service;

import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface OrdinationService {

    Ordination createOrder(OrdinationDTO ordinationDTO);
    Ordination findById(Integer id) throws NoStockIdFoundException;
    List<Ordination> findByAlbum(Integer id) throws NoOrdinationAlbumIdFoundException;
    List<Ordination> findBySingle(Integer id) throws NoOrdinationSingleIdFoundException;

    List<Ordination> findByGadget(Integer id) throws NoOrdinationGadgetIdFoundException;

    List<Ordination> findByOrderDate(String insertOrdinationDate) throws NoOrdinationInsertDateFoundException;

    void deleteOrder(Integer id);
}

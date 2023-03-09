package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.exception.NoGadgetIdFoundException;
import com.lucy.musicStore.exception.NoGadgetTypeFoundException;
import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.model.Gadget;

import java.util.List;

public interface GadgetService {

    Gadget findById(Integer id) throws NoGadgetIdFoundException;
    List<Gadget> findAll();
    Gadget save(GadgetDTO gadgetDTO);
    Gadget findByType(String type) throws NoGadgetTypeFoundException;

}

package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.exception.NoGadgetIdFoundException;
import com.lucy.musicStore.exception.NoGadgetTypeFoundException;
import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.mapper.GadgetMapper;
import com.lucy.musicStore.product.music.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GadgetServiceImpl implements GadgetService{
    @Autowired
    GadgetRepository gadgetRepository;

    @Autowired
    GadgetMapper gadgetMapper;
    @Override
    public Gadget findById(Integer id) throws NoGadgetIdFoundException {
        return this.gadgetRepository.findById(id).orElseThrow(NoGadgetIdFoundException::new);
    }

    @Override
    public List<Gadget> findAll() {
        return this.gadgetRepository.findAll();
    }

    @Override
    public Gadget save(GadgetDTO gadgetDTO) {
        return this.gadgetRepository.save(gadgetMapper.gadgetDTOToGadget(gadgetDTO));
    }

    @Override
    public Gadget findByType(String type) throws NoGadgetTypeFoundException {
        Gadget gadType = this.gadgetRepository.findByType(type);
        if (gadType == null) {
            throw new NoGadgetTypeFoundException();
        }
        return gadType;
    }
}

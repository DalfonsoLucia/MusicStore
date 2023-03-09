package com.lucy.musicStore.product.music.controller;

import com.lucy.musicStore.exception.NoGadgetIdFoundException;
import com.lucy.musicStore.exception.NoGadgetTypeFoundException;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gadget")
public class GadgetController {
    @Autowired
    GadgetService gadgetService;

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gadget findById(@PathVariable Integer id) throws NoGadgetIdFoundException {
         return gadgetService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Gadget> findAll() {
        return gadgetService.findAll();
    }

    @GetMapping("type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public Gadget findByType(@PathVariable String type) throws NoGadgetTypeFoundException {
        return gadgetService.findByType(type);
    }


}

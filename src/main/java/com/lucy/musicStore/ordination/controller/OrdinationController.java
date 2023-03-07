package com.lucy.musicStore.ordination.controller;

import com.lucy.musicStore.exception.NoStockIdFoundException;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.ordination.service.OrdinationService;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrdinationController {

    @Autowired
    OrdinationService ordinationService;

    @PostMapping("newOrder")
    @ResponseStatus(HttpStatus.OK)
    public Ordination createNewOrder(@RequestBody OrdinationDTO ordinationDTO) {
        return ordinationService.createOrder(ordinationDTO);
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ordination findById(Integer id) throws NoStockIdFoundException {
        return ordinationService.findById(id);
    }

    @GetMapping("single/{single}")
    @ResponseStatus(HttpStatus.OK)
    public Ordination findBySingle(Single single) {
        return ordinationService.findBySingle(single);
    }

    @GetMapping("album/{album}")
    @ResponseStatus(HttpStatus.OK)
    public Ordination findByAlbum(Album album) {
        return ordinationService.findByAlbum(album);
    }

    @GetMapping("dateNewOrder/{insertOrdinationDate}")
    @ResponseStatus(HttpStatus.OK)
    public Ordination findByOrderDate(Date insertOrdinationDate) {
        return ordinationService.findByOrderDate(insertOrdinationDate);
    }
}

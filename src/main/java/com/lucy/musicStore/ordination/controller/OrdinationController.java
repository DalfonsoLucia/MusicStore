package com.lucy.musicStore.ordination.controller;

import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.ordination.service.OrdinationService;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
    public Ordination findById(@PathVariable Integer id) throws NoStockIdFoundException {
        return ordinationService.findById(id);
    }

    @GetMapping("single/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ordination> findBySingle(@PathVariable Integer id) throws NoOrdinationSingleIdFoundException {
        return ordinationService.findBySingle(id);
    }

    @GetMapping("album/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ordination> findByAlbum(@PathVariable Integer id) throws NoOrdinationAlbumIdFoundException {
        return ordinationService.findByAlbum(id);
    }

    @GetMapping("gadget/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ordination> findByGadget(@PathVariable Integer id) throws NoOrdinationGadgetIdFoundException {
        return ordinationService.findByGadget(id);
    }

    @GetMapping("dateNewOrder/{insertOrdinationDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ordination> findByOrderDate(@PathVariable String insertOrdinationDate) throws NoOrdinationInsertDateFoundException {
        return ordinationService.findByOrderDate(insertOrdinationDate);
    }

    @DeleteMapping("deleteOrder/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        ordinationService.deleteOrder(id);
        return new ResponseEntity<> ("selected order successfully deleted", HttpStatus.OK);
    }
}

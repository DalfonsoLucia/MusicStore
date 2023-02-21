package com.lucy.musicStore.product.music.controller;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFoundException;
import com.lucy.musicStore.product.music.exception.NoPriceFoundException;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import com.lucy.musicStore.product.music.exception.NoTitleFoundException;
import com.lucy.musicStore.product.music.service.SingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/single")
public class SingleController {

    @Autowired
    private SingleService singleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SingleDTO> getAllSingles() throws NoSingleContentException {
        return singleService.findAllSingles();
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleDTO findById(@PathVariable Integer id) {
        return singleService.findById(id);
    }

    @GetMapping("{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<SingleDTO> findByArtist(@PathVariable String artist) throws NoArtistFoundException, NoSingleContentException {
        return singleService.findByArtist(artist);
    }

    @GetMapping("title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<SingleDTO> findByTitle(@PathVariable String title) throws NoTitleFoundException {
        return singleService.findByTitle(title);
    }

    @GetMapping("price/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<SingleDTO> findByPrice(@PathVariable Double price) throws NoPriceFoundException {
        return singleService.findByPrice(price);
    }
}

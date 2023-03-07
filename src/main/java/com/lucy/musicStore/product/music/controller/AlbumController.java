package com.lucy.musicStore.product.music.controller;

import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDTO> getAllAlbum() throws NoAlbumContentException {
        return albumService.findAllAlbum();
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumDTO findById(@PathVariable Integer id) throws NoAlbumIdFoundException {
        return albumService.findById(id);
    }

    @GetMapping("{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDTO> findByArtist(@PathVariable String artist) throws NoArtistFoundException {
        return albumService.findByArtist(artist);
    }

    @GetMapping("title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDTO> findByTitle(@PathVariable String title) throws NoTitleFoundException {
        return albumService.findByTitle(title);
    }

    @GetMapping("year/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDTO> findByYear(@PathVariable Date year) throws NoYearFoundException {
        return albumService.findByYear(year);
    }

    @GetMapping("price/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDTO> findByPrice(@PathVariable Double price) throws NoPriceFoundException {
        return albumService.findByPrice(price);
    }

}

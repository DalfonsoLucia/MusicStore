package com.lucy.musicStore.product.music.controller;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFound;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import com.lucy.musicStore.product.music.service.SingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("findById")
    @ResponseStatus(HttpStatus.OK)
    public SingleDTO findById(Integer id) {
        return singleService.findById(findById(id).getId());
    }

    @GetMapping("findByArtist")
    @ResponseStatus(HttpStatus.OK)
    public List<SingleDTO> findByArtist(String artist) throws NoArtistFound, NoSingleContentException {
        return singleService.findByArtist(artist);
    }



}

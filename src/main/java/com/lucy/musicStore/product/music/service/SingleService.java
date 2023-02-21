package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFoundException;
import com.lucy.musicStore.product.music.exception.NoPriceFoundException;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import com.lucy.musicStore.product.music.exception.NoTitleFoundException;

import java.util.List;

public interface SingleService {

    List<SingleDTO> findAllSingles() throws NoSingleContentException;
    SingleDTO findById(Integer id);
    List<SingleDTO> findByArtist(String artist) throws NoSingleContentException, NoArtistFoundException;
    List<SingleDTO> findByTitle(String title) throws NoTitleFoundException;
    List<SingleDTO> findByPrice(Double price) throws NoPriceFoundException;



}

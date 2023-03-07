package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.exception.NoArtistFoundException;
import com.lucy.musicStore.exception.NoPriceFoundException;
import com.lucy.musicStore.exception.NoSingleIdFoundException;
import com.lucy.musicStore.exception.NoTitleFoundException;

import java.util.List;

public interface SingleService {

    List<SingleDTO> findAllSingles() throws NoSingleIdFoundException;
    SingleDTO findById(Integer id) throws NoSingleIdFoundException;
    List<SingleDTO> findByArtist(String artist) throws NoArtistFoundException, NoSingleIdFoundException;
    List<SingleDTO> findByTitle(String title) throws NoTitleFoundException;
    List<SingleDTO> findByPrice(Double price) throws NoPriceFoundException;



}

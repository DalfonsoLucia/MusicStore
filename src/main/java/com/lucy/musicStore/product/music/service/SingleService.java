package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.exception.NoArtistFound;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SingleService {

    List<SingleDTO> findAllSingles() throws NoSingleContentException;
    SingleDTO findById(Integer id);
    List<SingleDTO> findByArtist(String artist) throws NoSingleContentException, NoArtistFound;



}

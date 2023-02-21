package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.exception.*;

import java.util.Date;
import java.util.List;

public interface AlbumService {

    List<AlbumDTO> findAllAlbum() throws NoAlbumContentException;

    AlbumDTO findById(Integer id);
    List<AlbumDTO> findByArtist(String artist) throws NoArtistFoundException;
    List<AlbumDTO> findByTitle(String title) throws NoTitleFoundException;
    List<AlbumDTO> findByYear(Date year) throws NoYearFoundException;
    List<AlbumDTO> findByPrice(Double price) throws NoPriceFoundException;
}

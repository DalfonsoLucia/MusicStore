package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.exception.*;
import com.lucy.musicStore.product.music.mapper.AlbumMapper;
import com.lucy.musicStore.product.music.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;


    @Override
    public List<AlbumDTO> findAllAlbum() throws NoAlbumContentException {
        return this.albumRepository.findAll().stream()
                .map(album -> albumMapper.albumToAlbumDTO(album))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoAlbumContentException::new);
    }

    @Override
    public AlbumDTO findById(Integer id) {
        return albumMapper.albumToAlbumDTO(albumRepository.findById(id).get());
    }

    @Override
    public List<AlbumDTO> findByArtist(String artist) throws NoArtistFoundException {
        return this.albumRepository.findByArtist(artist).stream()
                .map(album -> albumMapper.albumToAlbumDTO(album))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFoundException::new);
    }

    @Override
    public List<AlbumDTO> findByTitle(String title) throws NoTitleFoundException {
        return this.albumRepository.findByTitle(title).stream()
                .map(album -> albumMapper.albumToAlbumDTO(album))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoTitleFoundException::new);
    }

    @Override
    public List<AlbumDTO> findByYear(Date year) throws NoYearFoundException {
        return this.albumRepository.findByYear(year).stream()
                .map(album -> albumMapper.albumToAlbumDTO(album))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoYearFoundException::new);
    }

    @Override
    public List<AlbumDTO> findByPrice(Double price) throws NoPriceFoundException {
        return this.albumRepository.findByPrice(price).stream()
                .map(album -> albumMapper.albumToAlbumDTO(album))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoPriceFoundException::new);
    }


}

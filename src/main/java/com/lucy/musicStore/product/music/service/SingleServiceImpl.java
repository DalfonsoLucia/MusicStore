package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFoundException;
import com.lucy.musicStore.product.music.exception.NoPriceFoundException;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import com.lucy.musicStore.product.music.exception.NoTitleFoundException;
import com.lucy.musicStore.product.music.mapper.SingleMapper;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SingleServiceImpl implements SingleService{

    @Autowired
    private SingleRepository singleRepository;

    @Autowired
    private SingleMapper mapper;

    @Override
    public List<SingleDTO> findAllSingles() throws NoSingleContentException {
        return this.singleRepository.findAll().stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoSingleContentException::new);
    }

    @Override
    public SingleDTO findById(Integer id) {
        return mapper.singleToSingleDTO(singleRepository.findById(id).get());
    }

    @Override
    public List<SingleDTO> findByArtist(String artist) throws NoSingleContentException, NoArtistFoundException {
        return this.singleRepository.findByArtist(artist).stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFoundException::new);
    }

    @Override
    public List<SingleDTO> findByTitle(String title) throws NoTitleFoundException {
        return this.singleRepository.findByTitle(title).stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoTitleFoundException::new);
    }

    @Override
    public List<SingleDTO> findByPrice(Double price) throws NoPriceFoundException {
        return this.singleRepository.findByPrice(price).stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoPriceFoundException::new);
    }

}

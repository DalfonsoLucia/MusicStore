package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.exception.NoArtistFoundException;
import com.lucy.musicStore.exception.NoPriceFoundException;
import com.lucy.musicStore.exception.NoSingleIdFoundException;
import com.lucy.musicStore.exception.NoTitleFoundException;
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
    public List<SingleDTO> findAllSingles() throws NoSingleIdFoundException {
        return this.singleRepository.findAll().stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoSingleIdFoundException::new);
    }

    @Override
    public SingleDTO findById(Integer id) throws NoSingleIdFoundException {
        return mapper.singleToSingleDTO(singleRepository.findById(id).orElseThrow(NoSingleIdFoundException::new));
    }

    @Override
    public List<SingleDTO> findByArtist(String artist) throws NoArtistFoundException {
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

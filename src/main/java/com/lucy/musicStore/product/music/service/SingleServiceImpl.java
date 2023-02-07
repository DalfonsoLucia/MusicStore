package com.lucy.musicStore.product.music.service;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.exception.NoArtistFound;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import com.lucy.musicStore.product.music.mapper.SingleMapper;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import com.lucy.musicStore.sale.data.mapper.SaleMapper;
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
    public List<SingleDTO> findByArtist(String artist) throws NoSingleContentException, NoArtistFound {
        return this.singleRepository.findByArtist(artist).stream()
                .map(single -> mapper.singleToSingleDTO(single))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty()).orElseThrow(NoArtistFound::new);
    }


}

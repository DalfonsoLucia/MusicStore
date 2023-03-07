package com.lucy.musicStore.ordination.service;

import com.lucy.musicStore.exception.NoStockIdFoundException;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.ordination.repository.OrdinationRepository;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.repository.AlbumRepository;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdinationServiceImpl implements OrdinationService {

    @Autowired
    OrdinationRepository ordinationRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SingleRepository singleRepository;

    @Override
    public Ordination createOrder(OrdinationDTO ordinationDTO) {
        Ordination order = new Ordination();

        order.setSingles(findBySingleOrder(ordinationDTO.getSingles()));
        order.setAlbums(findByAlbumOrder(ordinationDTO.getAlbums()));
        Date date = new Date();
        date.setHours(date.getHours()+1);
        order.setInsertOrdinationDate(date);/*
        albumRepository.saveAll(order.getAlbums());
        singleRepository.saveAll(order.getSingles());*/
        ordinationRepository.save(order);
        return order;
    }

    public List<Album> findByAlbumOrder(List<Album> albums) {
        List<Album> albumList = new ArrayList<>();
        for (Album album : albums) {
            Album itemAlbum = albumRepository.findByTitleAndArtist(album.getTitle(), album.getArtist());
            if (itemAlbum==null) {
                albumRepository.save(album);
                itemAlbum = albumRepository.findByTitleAndArtist(album.getTitle(), album.getArtist());
            }
            albumList.add(itemAlbum);
        }
        return albumList;
    }

    public List<Single> findBySingleOrder(List<Single> singles) {
        List<Single> singleList = new ArrayList<>();
        for (Single single : singles) {
            Single itemSingle = singleRepository.findByTitleAndArtist(single.getTitle(), single.getArtist());
            if (itemSingle==null) {
                singleRepository.save(single);
                itemSingle = singleRepository.findByTitleAndArtist(single.getTitle(), single.getArtist());
            }
            singleList.add(itemSingle);
        }
        return singleList;
    }

    @Override
    public Ordination findById(Integer id) throws NoStockIdFoundException {
        return this.ordinationRepository.findById(id).orElseThrow(NoStockIdFoundException::new);
    }

    @Override
    public Ordination findByAlbum(Album album) {
        return this.ordinationRepository.findByAlbum(album.getId());
    }

    @Override
    public Ordination findBySingle(Single single) {
        return this.ordinationRepository.findBySingle(single.getId());
    }

    @Override
    public Ordination findByOrderDate(Date insertOrdinationDate) {
        return this.ordinationRepository.findByInsertOrdinationDate(insertOrdinationDate);
    }
}

package com.lucy.musicStore.ordination.service;

import com.lucy.musicStore.exception.*;
import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import com.lucy.musicStore.ordination.repository.OrdinationRepository;
import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.repository.AlbumRepository;
import com.lucy.musicStore.product.music.repository.GadgetRepository;
import com.lucy.musicStore.product.music.repository.SingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdinationServiceImpl implements OrdinationService {

    @Autowired
    OrdinationRepository ordinationRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SingleRepository singleRepository;

    @Autowired
    GadgetRepository gadgetRepository;

    @Override
    public Ordination createOrder(OrdinationDTO ordinationDTO) {
        Ordination order = new Ordination();

        order.setSingles(findBySingleOrder(ordinationDTO.getSingles()));
        order.setAlbums(findByAlbumOrder(ordinationDTO.getAlbums()));
        order.setGadgets(findByGadgetOrder(ordinationDTO.getGadgets()));
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
            Integer quanAl = album.getQuantity();
            Album itemAlbum = albumRepository.findByTitleAndArtist(album.getTitle(), album.getArtist());
            if (itemAlbum==null) {
                albumRepository.save(album);
                itemAlbum = albumRepository.findByTitleAndArtist(album.getTitle(), album.getArtist());
            }
            itemAlbum.setQuantity(quanAl);
            itemAlbum.setInsertDate(new Date());
            albumList.add(itemAlbum);
        }
        return albumList;
    }

    public List<Single> findBySingleOrder(List<Single> singles) {
        List<Single> singleList = new ArrayList<>();
        for (Single single : singles) {
            Integer quanSin = single.getQuantity();
            Single itemSingle = singleRepository.findByTitleAndArtist(single.getTitle(), single.getArtist());
            if (itemSingle==null) {
                singleRepository.save(single);
                itemSingle = singleRepository.findByTitleAndArtist(single.getTitle(), single.getArtist());
            }
            itemSingle.setQuantity(quanSin);
            itemSingle.setInsertDate(new Date());
            singleList.add(itemSingle);
        }
        return singleList;
    }

    public List<Gadget> findByGadgetOrder(List<Gadget> gadgets) {
        List<Gadget> gadgetList = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            Integer quanGad = gadget.getQuantity();
            Gadget itemGadget = gadgetRepository.findByType(gadget.getType());
            if (itemGadget==null) {
                gadgetRepository.save(gadget);
                itemGadget = gadgetRepository.findByType(gadget.getType());
            }
            itemGadget.setQuantity(quanGad);
            itemGadget.setInsertDateGadget(new Date());
            gadgetList.add(itemGadget);
        }
        return gadgetList;
    }

    @Override
    public Ordination findById(Integer id) throws NoStockIdFoundException {
        return this.ordinationRepository.findById(id).orElseThrow(NoStockIdFoundException::new);
    }

    @Override
    public List<Ordination> findByAlbum(Integer id) throws NoOrdinationAlbumIdFoundException {
        List<Ordination> ordersAlbum = this.ordinationRepository.findByAlbum(id);
        if (ordersAlbum.isEmpty()) {
            throw new NoOrdinationAlbumIdFoundException();
        }
        return ordersAlbum;
    }

    @Override
    public List<Ordination> findBySingle(Integer id) throws NoOrdinationSingleIdFoundException {
        List<Ordination> ordersSingle = this.ordinationRepository.findBySingle(id);
        if (ordersSingle.isEmpty()) {
            throw new NoOrdinationSingleIdFoundException();
        }
        return ordersSingle;
    }

    @Override
    public List<Ordination> findByGadget(Integer id) throws NoOrdinationGadgetIdFoundException {
        List<Ordination> ordersGadget = this.ordinationRepository.findByGadget(id);
        if (ordersGadget.isEmpty()) {
            throw new NoOrdinationGadgetIdFoundException();
        }
        return ordersGadget;
    }

    @Override
    public List<Ordination> findByOrderDate(String insertOrdinationDate) throws NoOrdinationInsertDateFoundException {
        List<Ordination> ordersDate = this.ordinationRepository.findByInsertOrdinationDate(insertOrdinationDate.toString()+"%");
        if (ordersDate.isEmpty()) {
            throw new NoOrdinationInsertDateFoundException();
        }
        return ordersDate;
    }
}

package com.lucy.musicStore.product.music.repository;

import com.lucy.musicStore.product.music.data.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findAll();

    List<Album> findByArtist(String artist);
    List<Album> findByTitle(String title);
    List<Album> findByYear(Date year);
    List<Album> findByPrice(Double price);
    Album findByTitleAndArtist(String title, String artist);
}

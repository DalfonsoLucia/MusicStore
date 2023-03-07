package com.lucy.musicStore.product.music.repository;

import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.exception.NoArtistFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SingleRepository extends JpaRepository<Single, Integer> {

    @Override
    List<Single> findAll();

    Optional<Single> findById(Integer id);

    List<Single> findByArtist(String artist) throws NoArtistFoundException;
    List<Single> findByTitle(String title);
    List<Single> findByPrice(Double price);
    Single findByTitleAndArtist(String title, String artist);
}

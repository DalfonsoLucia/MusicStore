package com.lucy.musicStore.product.music.repository;

import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.exception.NoArtistFound;
import com.lucy.musicStore.product.music.exception.NoSingleContentException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SingleRepository extends JpaRepository<Single, Integer> {

    @Override
    List<Single> findAll();

    Optional<Single> findById(Integer id);

    List<Single> findByArtist(String artist) throws NoSingleContentException, NoArtistFound;
}

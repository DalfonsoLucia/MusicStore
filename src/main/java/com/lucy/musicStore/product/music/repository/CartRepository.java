package com.lucy.musicStore.product.music.repository;

import com.lucy.musicStore.product.music.data.model.Cart;
import com.lucy.musicStore.product.music.data.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Override
    List<Cart> findAll();

    Optional<Cart> findById(Integer id);
    List<Cart> findByArtist(String artist);
    List<Cart> findByTitle(String title);
    //List<Sale> findTotalPrice(Double price);
}

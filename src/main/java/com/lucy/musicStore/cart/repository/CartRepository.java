package com.lucy.musicStore.cart.repository;

import com.lucy.musicStore.cart.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Override
    List<Cart> findAll();
    Optional<Cart> findById(Integer id);

    @Query(value = "SELECT c.* FROM Cart c " +
            "JOIN cart_detail cd ON cd.id_cart = c.id_cart " +
            "WHERE cd.artist = :artist", nativeQuery = true)
    List<Cart> findByArtist(@Param("artist") String artist);

    @Query(value = "SELECT c.* FROM Cart c " +
            "JOIN cart_detail cd ON cd.id_cart = c.id_cart " +
            "WHERE cd.title = :title", nativeQuery = true)
    List<Cart> findByTitle(@Param("title") String title);


    //List<Cart> calculateSubtotal(List<MusicDetailDTO> musicDetailDTOS);

    List<Cart> findBySubtotal(Double subtotal);

}
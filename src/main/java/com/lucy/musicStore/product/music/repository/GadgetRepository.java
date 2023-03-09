package com.lucy.musicStore.product.music.repository;

import com.lucy.musicStore.product.music.data.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Integer> {

    Gadget findByType(String type);
}

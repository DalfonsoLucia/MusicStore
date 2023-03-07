package com.lucy.musicStore.ordination.repository;

import com.lucy.musicStore.ordination.data.model.Ordination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrdinationRepository extends JpaRepository<Ordination, Integer> {

    @Query(value = "SELECT o.* FROM ordination o JOIN ordination_albums oa WHERE oa.albums_id_album = :id" ,nativeQuery = true)
    Ordination findByAlbum(@Param("id")Integer id);

    @Query(value = "SELECT o.* FROM ordination o JOIN ordination_singles os WHERE os.singles_id_single = :id" ,nativeQuery = true)
    Ordination findBySingle(@Param("id")Integer id);

    Ordination findByInsertOrdinationDate(Date insertOrdinationDate);
}
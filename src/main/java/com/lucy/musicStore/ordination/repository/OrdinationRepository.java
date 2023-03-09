package com.lucy.musicStore.ordination.repository;

import com.lucy.musicStore.exception.NoOrdinationGadgetIdFoundException;
import com.lucy.musicStore.exception.NoOrdinationSingleIdFoundException;
import com.lucy.musicStore.ordination.data.model.Ordination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface OrdinationRepository extends JpaRepository<Ordination, Integer> {

    @Query(value = "SELECT o.* FROM ordination o JOIN ordination_albums oa WHERE oa.albums_id_album = :id" ,nativeQuery = true)
    List<Ordination> findByAlbum(@Param("id")Integer id);

    @Query(value = "SELECT o.* FROM ordination o JOIN ordination_singles os WHERE os.singles_id_single = :id" ,nativeQuery = true)
    List<Ordination> findBySingle(@Param("id")Integer id) throws NoOrdinationSingleIdFoundException;

    @Query(value = "SELECT o.* FROM ordination o JOIN ordination_gadgets os WHERE os.gadgets_id_gadget = :id" ,nativeQuery = true)
    List<Ordination> findByGadget(@Param("id")Integer id) throws NoOrdinationGadgetIdFoundException;

    @Query(value = "SELECT o.* FROM ordination o WHERE o.insert_ordination_date like :insert_ordination_date" ,nativeQuery = true)
    List<Ordination> findByInsertOrdinationDate(@Param("insert_ordination_date") String insertOrdinationDate);
}
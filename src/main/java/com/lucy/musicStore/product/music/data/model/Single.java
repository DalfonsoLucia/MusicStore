package com.lucy.musicStore.product.music.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Single.TABLE_NAME)
public class Single extends MusicDetail {
    public static final String TABLE_NAME = "single";

    @Id
    @Column(name = "id_single")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToMany(mappedBy = "relSingles")
    List<Album> relAlbums;

    @ManyToOne
    @JoinColumn(name = "id_artist_detail", nullable=false)
    private ArtistDetail artistDetail;

    /*
    //relazione tra l'entità Sale e l'entità Single
    @ManyToMany(mappedBy = "singlesSale")
    List<Sale> SinglesSoldList;
     */

}

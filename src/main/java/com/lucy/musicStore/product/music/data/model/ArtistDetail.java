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
@Table(name = ArtistDetail.TABLE_NAME)
public class ArtistDetail {
    public static final String TABLE_NAME = "artist_detail";

    @Id
    @Column(name = "id_artist_detail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "artist")
    private String artist;
    @Column(name = "album")
    private String album;
    @Column(name = "genre")
    private String genre;
    @Column(name = "band_name")
    private String bandName;
    @Column(name = "description")
    private String description;
    @Column(name = "note")
    private String note;

    @OneToMany(targetEntity = Album.class, mappedBy = "artistDetail", fetch = FetchType.LAZY)
    List<Album> albumsList;

    @OneToMany(targetEntity = Single.class, mappedBy = "artistDetail", fetch = FetchType.LAZY)
    List<Single> singlesList;
}

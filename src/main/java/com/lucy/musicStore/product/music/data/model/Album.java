package com.lucy.musicStore.product.music.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Album.TABLE_NAME)
public class Album extends MusicDetail {
    public static final String TABLE_NAME = "album";

    @Id
    @Column(name = "id_album")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "track_number")
    private Integer tracksNumber;

    @ManyToMany
    @JoinTable(
            name = "musicRelation",
            joinColumns = @JoinColumn(name = "id_single"),
            inverseJoinColumns = @JoinColumn(name = "id_album"))
    List<Single> relSingles;

    @ManyToOne
    @JoinColumn(name = "id_artist_detail", nullable=false)
    private ArtistDetail artistDetail;

    /*
    //relazione tra l'entità Sale e l'entità Album
    @ManyToMany(mappedBy = "albumsSale")
    List<Sale> AlbumsSoldList;
     */

}

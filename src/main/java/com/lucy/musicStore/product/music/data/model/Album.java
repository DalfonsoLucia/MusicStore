package com.lucy.musicStore.product.music.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "musicRelation",
            joinColumns = @JoinColumn(name = "id_single"),
            inverseJoinColumns = @JoinColumn(name = "id_album"))
    List<Single> relSingles;

    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_artist_detail")
    private ArtistDetail artistDetail;


}

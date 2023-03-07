package com.lucy.musicStore.product.music.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToMany(mappedBy = "relSingles", cascade=CascadeType.ALL)
    List<Album> relAlbums;

    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_artist_detail")
    private ArtistDetail artistDetail;


}

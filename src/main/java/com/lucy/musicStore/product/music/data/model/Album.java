package com.lucy.musicStore.product.music.data.model;

import com.lucy.musicStore.product.music.data.model.abstactModel.ProductMusicAbstract;
import com.lucy.musicStore.stock.data.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Album.TABLE_NAME)
public class Album extends ProductMusicAbstract {
    public static final String TABLE_NAME = "album";

    @Id
    @Column(name = "ID_ALBUM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ARTIST")
    private String artist;
    @Column(name = "TRACKS_NUMBER")
    private Integer tracksNumber;
    @Column(name = "DURATION")
    private Time duration;


    @ManyToMany
    @JoinTable(
            name = "musicRelation",
            joinColumns = @JoinColumn(name = "ID_SINGLE"),
            inverseJoinColumns = @JoinColumn(name = "ID_ALBUM"))
    Set<Single> likedSingles;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable=false)
    private Stock stock;

}

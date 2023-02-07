package com.lucy.musicStore.product.music.data.model;

import com.lucy.musicStore.product.music.data.model.abstactModel.ProductMusicAbstract;
import com.lucy.musicStore.stock.data.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Single.TABLE_NAME)
public class Single extends ProductMusicAbstract {
    public static final String TABLE_NAME = "single";

    @Id
    @Column(name = "ID_SINGLE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ARTIST")
    private String artist;

    @ManyToMany(mappedBy = "likedSingles")
    Set<Album> likedAlbums;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable=false)
    private Stock stock;



}

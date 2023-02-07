package com.lucy.musicStore.stock.data.model;

import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;
import com.lucy.musicStore.product.music.data.model.abstactModel.ProductMusicAbstract;
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
@Table(name = Stock.TABLE_NAME)
public class Stock {
    public static final String TABLE_NAME = "stock";

    @Id
    @Column(name = "ID_STOCK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Album.class, mappedBy = "stock", fetch = FetchType.LAZY)
    Set<ProductMusicAbstract> productsAlbum;

    @OneToMany(targetEntity = Single.class, mappedBy = "stock", fetch = FetchType.LAZY)
    Set<ProductMusicAbstract> productsSingle;




}

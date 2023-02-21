package com.lucy.musicStore.product.music.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class MusicDetail {

    @Column(name = "artist")
    private String artist;
    @Column(name = "title")
    private String title;
    @Column(name = "year_release")
    private Date year;
    @Column(name = "price")
    private Double price;
    @Column(name = "genre")
    private String genre;
    @Column(name = "amount_stock")
    private Double amountStock;
    @Column(name = "typology")
    private String type;
    @Column(name = "insert_date")
    private Date insertDate;






}

package com.lucy.musicStore.stock.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "ARTIST")
    private String artist;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ALBUM")
    private String album;
    @Column(name = "SORT_KIND")
    private String type;
    @Column(name = "UNIT_PRICE")
    private String unitPrice;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
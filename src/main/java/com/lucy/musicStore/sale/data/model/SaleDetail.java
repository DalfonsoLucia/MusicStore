package com.lucy.musicStore.sale.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SaleDetail {

    @Id
    @Column(name = "id_sale_detail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "artist")
    private String artist;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "description")
    private String description;
    @Column(name = "typology")
    private String type;
    @Column(name = "note")
    private String note;

    @OneToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;
}

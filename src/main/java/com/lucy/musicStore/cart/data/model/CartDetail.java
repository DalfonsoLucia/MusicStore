package com.lucy.musicStore.cart.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = CartDetail.TABLE_NAME)
public class CartDetail {
    public static final String TABLE_NAME = "cart_detail";

    @Id
    @Column(name = "id_cart_detail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "artist")
    private String artist;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @JsonIgnore
    @Column(name = "description")
    private String description;
    @Column(name = "typology")
    private String type;
    @JsonIgnore
    @Column(name = "note")
    private String note;
    @Column(name = "quantity")
    private Integer quantity;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;
}

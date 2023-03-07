package com.lucy.musicStore.cart.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucy.musicStore.sale.data.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Cart.TABLE_NAME)
public class Cart {
    public static final String TABLE_NAME = "cart";

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;/*
    @Column(name = "unit_price")
    private Double unitPrice;*/
    @Column(name = "amounts_purchased")
    private Double amountPurchased;
    @Column(name = "subtotal")
    private Double subtotal;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "insert_cart_date")
    private Date insertCartsDate;/*
    @Column(name = "sold")
    private Boolean sold;*/

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Sale sale;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;
}


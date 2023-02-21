package com.lucy.musicStore.product.music.data.model;

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
@Table(name = Cart.TABLE_NAME)
public class Cart extends ManagementDetail {
    public static final String TABLE_NAME = "cart";

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "amount_sale")
    private Double amountSale;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "insert_cart_date")
    private Date insertCartsDate;

}


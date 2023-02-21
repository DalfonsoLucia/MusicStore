package com.lucy.musicStore.product.music.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Sale.TABLE_NAME)
public class Sale extends ManagementDetail {
    public static final String TABLE_NAME = "sale";

    @Id
    @Column(name = "id_sale")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "item_numeber")
    private Integer itemNumber;
    @Column(name = "total_price")
    private Double totalPrice;

}

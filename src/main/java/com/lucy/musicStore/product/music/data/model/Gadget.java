package com.lucy.musicStore.product.music.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Entity
@Table(name = Gadget.TABLE_NAME)
public class Gadget {
    public static final String TABLE_NAME = "gadget";

    @Id
    @Column(name = "id_gadget")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "typology")
    private String type;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "amount_stock_gadget")
    private Double amountStockGadget;
    @Column(name = "insert_date_gadget")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date insertDateGadget;

}

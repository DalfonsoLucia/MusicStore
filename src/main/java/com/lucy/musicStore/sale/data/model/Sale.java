package com.lucy.musicStore.sale.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucy.musicStore.cart.data.model.Cart;
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
@Table(name = Sale.TABLE_NAME)
public class Sale {
    public static final String TABLE_NAME = "sale";

    @Id
    @Column(name = "id_sale")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "item_numeber")
    private Integer itemNumber;
    @Column(name = "total_price")
    private Double totalPrice;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "insert_sale_date")
    private Date insertSalesDate;
    @Column(name = "sold")
    private Boolean sold;

    //è una ManyToOne perchè
    // in un carrello ci possono essere più record che comporanno poi una vendita
    @OneToOne(targetEntity=Cart.class, mappedBy="sale",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;


    /*@OneToOne(mappedBy = "sale")
    private SaleDetail saleDetail;*/

}

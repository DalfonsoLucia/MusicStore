package com.lucy.musicStore.cart.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDTO {

    private Integer id;
    //private Double unitPrice;
    private Double amountPurchased;
    private Double subtotal;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date insertCartsDate;
    //private Boolean sold;
}



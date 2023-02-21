package com.lucy.musicStore.product.music.data.dto;

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
    private String artist;
    private String title;
    private String genre;
    private String type;
    private Double unitPrice;
    private Double amountSale;
    private Date insertCartsDate;
}



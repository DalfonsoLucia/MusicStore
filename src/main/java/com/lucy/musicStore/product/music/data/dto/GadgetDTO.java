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
public class GadgetDTO {

    private Integer id;
    private String type;
    private Integer quantity;
    private Double price;
    private Double amountStockGadget;
    private Date insertDateGadget;

}

package com.lucy.musicStore.stock.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockDTO {

    private Integer id;
    private String artist;
    private String title;
    private String type;
    private String unitPrice;
    private Double amount;
    private Double totalPrice;
}

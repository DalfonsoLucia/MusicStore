package com.lucy.musicStore.sale.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDTO {

    private Integer id;
    private Integer itemNumber;
    private Double totalPrice;
    private Date insertSalesDate;
    private Boolean sold;
}

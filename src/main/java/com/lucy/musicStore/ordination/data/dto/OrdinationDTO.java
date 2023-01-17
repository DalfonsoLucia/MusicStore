package com.lucy.musicStore.ordination.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdinationDTO {

    private Integer id;
    private String artist;
    private String title;
    private String type;
    private String unitPrice;
    private Double amount;
    private Double totalPrice;
}

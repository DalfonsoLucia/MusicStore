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
public class MusicDetailDTO {

    private Integer id;
    private String artist;
    private String title;
    private Date year;
    private Double price;
    private String genre;
    private Integer quantity;
    private Double amountStock;
    private String type;
    private Date insertDate;
}

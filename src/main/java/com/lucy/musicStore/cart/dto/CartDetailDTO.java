package com.lucy.musicStore.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDetailDTO {

    private String id;
    private String artist;
    private String title;
    private String genre;
    private String description;
    private String type;
    private String note;
}

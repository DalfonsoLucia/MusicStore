package com.lucy.musicStore.product.music.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumDTO {
    private Integer id;
    private String artist;
    private String title;
    private String genre;
    private String type;
}

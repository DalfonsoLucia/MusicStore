package com.lucy.musicStore.product.music.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistDetailDTO {

    private Integer id;
    private String artist;
    private String album;
    private String genre;
    private String bandName;
    private String description;
    private String note;
}

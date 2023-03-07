package com.lucy.musicStore.product.music.data.dto;

import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Single;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    List<Album> albumsList;
    List<Single> singlesList;
}

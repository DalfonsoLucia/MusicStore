package com.lucy.musicStore.product.music.data.dto;

import com.lucy.musicStore.product.music.data.model.ArtistDetail;
import com.lucy.musicStore.product.music.data.model.Single;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumDTO {
    private Integer id;
    private String artist;
    private String title;
    private String genre;
    private Date year;
    private Double amountStock;
    private String type;
    private Date insertDate;
    private Double price;
    List<Single> relSingles;
    private ArtistDetail artistDetail;

}

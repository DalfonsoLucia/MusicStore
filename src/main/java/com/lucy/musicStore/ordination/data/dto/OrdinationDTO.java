package com.lucy.musicStore.ordination.data.dto;

import com.lucy.musicStore.product.music.data.model.Album;
import com.lucy.musicStore.product.music.data.model.Gadget;
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
public class OrdinationDTO {

    private Integer id;
    private Date insertOrdinationDate;
    private List<Album> albums;
    private List<Single> singles;

    private List<Gadget> gadgets;
}

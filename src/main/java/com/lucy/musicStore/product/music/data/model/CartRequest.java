package com.lucy.musicStore.product.music.data.model;

import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.dto.MusicDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartRequest {

    private List<MusicDetailDTO> musicDetailDTOList;
    private List<GadgetDTO> gadgetList;
}

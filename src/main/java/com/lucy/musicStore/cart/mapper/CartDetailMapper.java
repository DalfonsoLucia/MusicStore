package com.lucy.musicStore.cart.mapper;

import com.lucy.musicStore.cart.data.model.CartDetail;
import com.lucy.musicStore.cart.dto.CartDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CartDetailMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "note", target = "note")
    CartDetailDTO cartDetailToCartDetailDTO(CartDetail cartDetail);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "note", target = "note")
    CartDetail cartDetailDTOToCartDetail(CartDetailDTO cartDetailDTO);
}
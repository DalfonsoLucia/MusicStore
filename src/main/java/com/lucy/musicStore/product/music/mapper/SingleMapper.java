package com.lucy.musicStore.product.music.mapper;

import com.lucy.musicStore.product.music.data.dto.SingleDTO;
import com.lucy.musicStore.product.music.data.model.Single;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SingleMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "amountStock", target = "amountStock")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDate", target = "insertDate")
    @Mapping(source = "price", target = "price")
    SingleDTO singleToSingleDTO(Single single);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "amountStock", target = "amountStock")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDate", target = "insertDate")
    @Mapping(source = "price", target = "price")
    Single singleDTOToSingle(SingleDTO singleDTO);
}
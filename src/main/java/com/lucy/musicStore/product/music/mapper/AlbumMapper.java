package com.lucy.musicStore.product.music.mapper;

import com.lucy.musicStore.product.music.data.dto.AlbumDTO;
import com.lucy.musicStore.product.music.data.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AlbumMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "amountStock", target = "amountStock")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDate", target = "insertDate")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "relSingles", target = "relSingles")
    @Mapping(source = "artistDetail", target = "artistDetail")
    AlbumDTO albumToAlbumDTO (Album album);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "amountStock", target = "amountStock")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDate", target = "insertDate")
    @Mapping(source = "price", target = "price")
    Album albumDTOToAlbum (AlbumDTO albumDTO);
}
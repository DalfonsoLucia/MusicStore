package com.lucy.musicStore.product.music.mapper;

import com.lucy.musicStore.product.music.data.dto.ArtistDetailDTO;
import com.lucy.musicStore.product.music.data.model.ArtistDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ArtistDetailMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "album", target = "album")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "bandName", target = "bandName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "note", target = "note")
    ArtistDetailDTO albumDetailToAlbumDetailDTO (ArtistDetail albumDetail);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "album", target = "album")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "bandName", target = "bandName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "note", target = "note")
    ArtistDetail albumDetailDTOToAlbumDetail (ArtistDetailDTO albumDetailDTO);
}

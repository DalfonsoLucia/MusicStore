package com.lucy.musicStore.album.data.dto;

import com.lucy.musicStore.album.data.model.Album;
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
    @Mapping(source = "type", target = "type")
    AlbumDTO albumToAlbumDTO (Album album);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "type", target = "type")
    Album albumDTOToAlbum (AlbumDTO albumDTO);
}


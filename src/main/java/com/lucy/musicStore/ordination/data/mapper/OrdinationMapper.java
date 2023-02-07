package com.lucy.musicStore.ordination.data.mapper;

import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import org.mapstruct.Mapping;

public interface OrdinationMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    OrdinationDTO ordinationToOrdinationDTO (Ordination ordination);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    Ordination ordinationDTOToOrdination (OrdinationDTO ordinationDTO);
}
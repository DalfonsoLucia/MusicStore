package com.lucy.musicStore.ordination.data.mapper;

import com.lucy.musicStore.ordination.data.dto.OrdinationDTO;
import com.lucy.musicStore.ordination.data.model.Ordination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrdinationMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "insertOrdinationDate", target = "insertOrdinationDate")
    OrdinationDTO ordinationToOrdinationDTO(Ordination ordination);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "insertOrdinationDate", target = "insertOrdinationDate")
    Ordination ordinationDTOToOrdination(OrdinationDTO ordination);
}
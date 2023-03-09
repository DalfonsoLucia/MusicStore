package com.lucy.musicStore.product.music.mapper;

import com.lucy.musicStore.product.music.data.dto.GadgetDTO;
import com.lucy.musicStore.product.music.data.model.Gadget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface GadgetMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "amountStockGadget", target = "amountStockGadget")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDateGadget", target = "insertDateGadget")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    GadgetDTO gadgetToGadgetDTO (Gadget gadget);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "amountStockGadget", target = "amountStockGadget")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "insertDateGadget", target = "insertDateGadget")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    Gadget gadgetDTOToGadget (GadgetDTO gadgetDTO);
}


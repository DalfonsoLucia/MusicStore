package com.lucy.musicStore.sale.data.dto;

import com.lucy.musicStore.sale.data.model.Sale;
import org.mapstruct.Mapping;

public interface SaleMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    SaleDTO saleToSaleDTO (Sale sale);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    Sale saleDTOToSale (SaleDTO saleDTO);
}
package com.lucy.musicStore.stock.data.dto;

import com.lucy.musicStore.stock.data.model.Stock;
import org.mapstruct.Mapping;

public interface StockMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    StockDTO stockToStockDTO (Stock stock);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "totalPrice", target = "totalPrice")
    Stock stockDTOToStock (StockDTO stockDTO);
}
package com.lucy.musicStore.sale.data.mapper;

import com.lucy.musicStore.sale.data.dto.SaleDTO;
import com.lucy.musicStore.sale.data.model.Sale;
import org.mapstruct.Mapping;

public interface SaleMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "itemNumber", target = "itemNumber")
    @Mapping(source = "totalPrice", target = "totalPrice")
    @Mapping(source = "insertSalesDate", target = "insertSalesDate")
    @Mapping(source = "sold", target = "sold")
    SaleDTO saleToSaleDTO(Sale sale);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "itemNumber", target = "itemNumber")
    @Mapping(source = "totalPrice", target = "totalPrice")
    @Mapping(source = "insertSalesDate", target = "insertSalesDate")
    @Mapping(source = "sold", target = "sold")
    Sale saleDTOToSale(SaleDTO saleDTO);
}

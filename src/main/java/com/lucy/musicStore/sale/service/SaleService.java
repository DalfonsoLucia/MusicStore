package com.lucy.musicStore.sale.service;

import com.lucy.musicStore.exception.NoSaleIdFoundException;
import com.lucy.musicStore.sale.data.model.Sale;

public interface SaleService {

    Sale findById(Integer id) throws NoSaleIdFoundException;
    Sale calculateFinalPrice(Integer id);
}

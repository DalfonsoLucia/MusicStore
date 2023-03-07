package com.lucy.musicStore.stock.service;

import com.lucy.musicStore.exception.NoStockIdFoundException;

public interface StockService {

    Integer updateAmountStock(Integer id, Boolean orderReceved) throws NoStockIdFoundException;
}

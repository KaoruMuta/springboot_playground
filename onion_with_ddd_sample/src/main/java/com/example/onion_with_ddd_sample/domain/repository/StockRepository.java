package com.example.onion_with_ddd_sample.domain.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Stock;

public interface StockRepository {

    Stock findCarStock(String carId);
    void updateStock(Stock stock);
}

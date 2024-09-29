package com.example.onion_with_ddd_sample.domain.model.entity;

public record Stock(String carId, Integer quantity) {

    public Stock decrease() {
        return new Stock(carId, quantity - 1);
    }
}

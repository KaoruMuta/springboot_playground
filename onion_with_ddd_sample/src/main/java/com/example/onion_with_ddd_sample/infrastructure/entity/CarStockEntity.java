package com.example.onion_with_ddd_sample.infrastructure.entity;

public class CarStockEntity {

    private String carId;
    private Integer quantity;

    public CarStockEntity(String carId, Integer quantity) {
        this.carId = carId;
        this.quantity = quantity;
    }

    public String getCarId() {
        return carId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

package com.example.onion_with_ddd_sample.infrastructure.entity;

public class CustomerPurchaseHistoryEntity {

    private String id;
    private String carId;
    private String customerId;

    public CustomerPurchaseHistoryEntity(String id, String carId, String customerId) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getCarId() {
        return carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

package com.example.onion_with_ddd_sample.domain.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getPurchasableCars();
}

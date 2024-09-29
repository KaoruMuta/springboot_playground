package com.example.onion_with_ddd_sample.usecase;

import com.example.onion_with_ddd_sample.domain.model.entity.Car;
import com.example.onion_with_ddd_sample.domain.repository.CarRepository;
import com.example.onion_with_ddd_sample.usecase.output.SearchAvailableCarOutput;

import java.util.List;

@Usecase
public class SearchAvailableCarUsecase {

    private final CarRepository carRepository;

    public SearchAvailableCarUsecase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<SearchAvailableCarOutput> execute() {
        List<Car> cars = carRepository.getPurchasableCars();
        return cars.stream()
                .map(e -> new SearchAvailableCarOutput(e.id(), e.name(), e.price()))
                .toList();
    }
}

package com.example.onion_with_ddd_sample.controller;

import com.example.onion_with_ddd_sample.controller.schema.CarPurchaseRequestBody;
import com.example.onion_with_ddd_sample.usecase.CarPurchaseUsecase;
import com.example.onion_with_ddd_sample.usecase.input.CarPurchaseUsecaseInput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    private final CarPurchaseUsecase carPurchaseUsecase;

    public PurchaseController(CarPurchaseUsecase carPurchaseUsecase) {
        this.carPurchaseUsecase = carPurchaseUsecase;
    }

    @PostMapping("/cars/{car_id}/purchase")
    public void purchase(@PathVariable("car_id") String carId, @RequestBody CarPurchaseRequestBody params) {
        CarPurchaseUsecaseInput input = new CarPurchaseUsecaseInput(carId, params.id(), params.name());
        carPurchaseUsecase.execute(input);
    }
}

package com.example.onion_with_ddd_sample.controller;

import com.example.onion_with_ddd_sample.controller.schema.CarPurchaseCancelRequestBody;
import com.example.onion_with_ddd_sample.usecase.CarPurchaseCancelUsecase;
import com.example.onion_with_ddd_sample.usecase.input.CarPurchaseCancelUsecaseInput;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseCancelController {

    private final CarPurchaseCancelUsecase carPurchaseCancelUsecase;

    public PurchaseCancelController(CarPurchaseCancelUsecase carPurchaseCancelUsecase) {
        this.carPurchaseCancelUsecase = carPurchaseCancelUsecase;
    }

    @DeleteMapping("/cars/{car_id}/cancel")
    public void cancel(@PathVariable("car_id") String carId, @RequestBody CarPurchaseCancelRequestBody params) {
        CarPurchaseCancelUsecaseInput input = new CarPurchaseCancelUsecaseInput(carId, params.id(), params.name());
        carPurchaseCancelUsecase.execute(input);
    }
}

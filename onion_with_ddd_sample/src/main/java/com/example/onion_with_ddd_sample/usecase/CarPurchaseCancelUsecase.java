package com.example.onion_with_ddd_sample.usecase;

import com.example.onion_with_ddd_sample.domain.model.entity.Stock;
import com.example.onion_with_ddd_sample.domain.repository.StockRepository;
import com.example.onion_with_ddd_sample.usecase.input.CarPurchaseCancelUsecaseInput;

@Usecase
public class CarPurchaseCancelUsecase {

    private final StockRepository stockRepository;

    public CarPurchaseCancelUsecase(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void execute(CarPurchaseCancelUsecaseInput input) {
        // NOTE: 在庫のみの更新のため、複数集約の整合性を保つ必要がないため、usecase内で完結させている
        Stock stock = stockRepository.findCarStock(input.carId());
        Stock stockAfterCancel = stock.increase();
        stockRepository.updateStock(stockAfterCancel);
    }
}

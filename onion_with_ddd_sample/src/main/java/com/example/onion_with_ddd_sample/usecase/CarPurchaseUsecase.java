package com.example.onion_with_ddd_sample.usecase;

import com.example.onion_with_ddd_sample.domain.model.entity.Customer;
import com.example.onion_with_ddd_sample.domain.model.entity.CustomerPurchaseHistory;
import com.example.onion_with_ddd_sample.domain.model.entity.Stock;
import com.example.onion_with_ddd_sample.domain.repository.StockRepository;
import com.example.onion_with_ddd_sample.domain.service.PurchaseWriteService;
import com.example.onion_with_ddd_sample.usecase.input.CarPurchaseUsecaseInput;

import java.util.UUID;

@Usecase
public class CarPurchaseUsecase {

    private final PurchaseWriteService purchaseWriteService;
    private final StockRepository stockRepository;

    public CarPurchaseUsecase(PurchaseWriteService purchaseWriteService, StockRepository stockRepository) {
        this.purchaseWriteService = purchaseWriteService;
        this.stockRepository = stockRepository;
    }

    public void execute(CarPurchaseUsecaseInput input) {
        Stock stock = stockRepository.findCarStock(input.carId());
        Stock stockAfterPurchase = stock.decrease();
        Customer customer = new Customer(input.customerId(), input.customerName());
        CustomerPurchaseHistory history = new CustomerPurchaseHistory(UUID.randomUUID().toString(), input.carId(), input.customerId());
        // NOTE: 整合性を担保したいモデル(集約)間を、1トランザクションで更新する (aggregatorとしての役割)
        purchaseWriteService.execute(stockAfterPurchase, customer, history);
    }
}

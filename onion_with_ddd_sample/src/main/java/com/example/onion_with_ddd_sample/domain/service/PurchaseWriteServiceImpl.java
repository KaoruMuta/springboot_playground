package com.example.onion_with_ddd_sample.domain.service;

import com.example.onion_with_ddd_sample.domain.model.entity.Customer;
import com.example.onion_with_ddd_sample.domain.model.entity.CustomerPurchaseHistory;
import com.example.onion_with_ddd_sample.domain.model.entity.Stock;
import com.example.onion_with_ddd_sample.domain.repository.CustomerRepository;
import com.example.onion_with_ddd_sample.domain.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseWriteServiceImpl implements PurchaseWriteService {

    private final StockRepository stockRepository;
    private final CustomerRepository customerRepository;

    public PurchaseWriteServiceImpl(CustomerRepository customerRepository, StockRepository stockRepository) {
        this.stockRepository = stockRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public void execute(Stock stock, Customer customer, CustomerPurchaseHistory customerPurchaseHistory) {
        // NOTE: 整合性を担保したいモデル(集約)間を、1トランザクションで更新する
        stockRepository.updateStock(stock);
        customerRepository.createCustomerIfNeeded(customer);
        customerRepository.createPurchaseHistory(customerPurchaseHistory);
    }
}

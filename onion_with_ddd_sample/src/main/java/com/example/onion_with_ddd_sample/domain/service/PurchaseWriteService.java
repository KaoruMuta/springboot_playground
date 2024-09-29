package com.example.onion_with_ddd_sample.domain.service;

import com.example.onion_with_ddd_sample.domain.model.entity.Customer;
import com.example.onion_with_ddd_sample.domain.model.entity.CustomerPurchaseHistory;
import com.example.onion_with_ddd_sample.domain.model.entity.Stock;

public interface PurchaseWriteService {

    void execute(Stock stock, Customer customer, CustomerPurchaseHistory customerPurchaseHistory);
}

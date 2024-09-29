package com.example.onion_with_ddd_sample.domain.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Customer;
import com.example.onion_with_ddd_sample.domain.model.entity.CustomerPurchaseHistory;

public interface CustomerRepository {

    void createCustomerIfNeeded(Customer customer);
    void createPurchaseHistory(CustomerPurchaseHistory customerPurchaseHistoryEntity);
}

package com.example.onion_with_ddd_sample.infrastructure.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Customer;
import com.example.onion_with_ddd_sample.domain.model.entity.CustomerPurchaseHistory;
import com.example.onion_with_ddd_sample.domain.repository.CustomerRepository;
import com.example.onion_with_ddd_sample.infrastructure.entity.CustomerEntity;
import com.example.onion_with_ddd_sample.infrastructure.entity.CustomerPurchaseHistoryEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createCustomerIfNeeded(Customer customer) {
        CustomerEntity entity = new CustomerEntity(customer.id(), customer.name());
        String query = """
                INSERT IGNORE INTO customers (id, name)
                VALUES (?, ?)
                """;
        jdbcTemplate.update(query, entity.getId(), entity.getName());
    }

    @Override
    public void createPurchaseHistory(CustomerPurchaseHistory customerPurchaseHistory) {
        CustomerPurchaseHistoryEntity entity = new CustomerPurchaseHistoryEntity(
                customerPurchaseHistory.id(),
                customerPurchaseHistory.carId(),
                customerPurchaseHistory.customerId()
        );
        String query = """
                INSERT IGNORE INTO customer_purchase_history (id, car_id, customer_id)
                VALUES (?, ?, ?)
                """;
        jdbcTemplate.update(query, entity.getId(), entity.getCarId(), entity.getCustomerId());
    }
}

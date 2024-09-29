package com.example.onion_with_ddd_sample.infrastructure.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Stock;
import com.example.onion_with_ddd_sample.domain.repository.StockRepository;
import com.example.onion_with_ddd_sample.infrastructure.entity.CarStockEntity;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepositoryImpl implements StockRepository {

    private final JdbcTemplate jdbcTemplate;

    public StockRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stock findCarStock(String carId) {
        String query = """
                SELECT
                    car_id,
                    quantity
                FROM
                    car_stocks
                WHERE
                    car_id = ?
                """;
        List<CarStockEntity> result = jdbcTemplate.query(query, new DataClassRowMapper<>(CarStockEntity.class), carId);
        // TODO: return exception when stock is not set up with car
        return result.stream()
                .map(e -> new Stock(e.getCarId(), e.getQuantity()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateStock(Stock stock) {
        CarStockEntity entity = new CarStockEntity(stock.carId(), stock.quantity());
        String query = """
                UPDATE
                    car_stocks
                SET
                    quantity = ?
                WHERE
                    car_id = ?
                """;
        jdbcTemplate.update(query, entity.getQuantity(), entity.getCarId());
    }
}

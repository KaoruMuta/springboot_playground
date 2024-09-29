package com.example.onion_with_ddd_sample.infrastructure.repository;

import com.example.onion_with_ddd_sample.domain.model.entity.Car;
import com.example.onion_with_ddd_sample.domain.repository.CarRepository;
import com.example.onion_with_ddd_sample.infrastructure.entity.CarEntity;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> getPurchasableCars() {
        // TODO: 在庫がある車両のみ取得するSQLを実行
        String query = """
                SELECT
                    c.id AS id,
                    c.name AS name,
                    c.price AS price
                FROM
                    cars c
                INNER JOIN
                    car_stocks cs
                ON
                    c.id = cs.car_id
                WHERE
                    cs.quantity > 0;
                """;
        // NOTE: entityにsetterを追加しないと、テーブルからとってきた値がセットされずnullがかえってしまう
        List<CarEntity> result = jdbcTemplate.query(query, new DataClassRowMapper<>(CarEntity.class));
        return result.stream()
                .map(e -> new Car(e.getId(), e.getName(), e.getPrice()))
                .toList();
    }
}

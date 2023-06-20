package com.example.multipledb.repository;

import com.example.multipledb.entity.PostgresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaPostgresqlRepository extends JpaRepository<PostgresEntity, String> {
    @Query(value = "SELECT entity.name FROM PostgresEntity entity")
    String fetchNameFromPostgresql();
}

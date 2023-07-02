package com.example.multipledb.repository.postgresql;

import com.example.multipledb.entity.postgresql.PostgresqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostgresqlRepository extends JpaRepository<PostgresqlEntity, String> {
    @Query(value = "SELECT entity.name FROM PostgresqlEntity entity")
    String fetchNameFromPostgresql();
}

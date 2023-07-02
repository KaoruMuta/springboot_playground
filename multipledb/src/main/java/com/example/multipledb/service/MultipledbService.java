package com.example.multipledb.service;

import com.example.multipledb.repository.JdbcRepository;
import com.example.multipledb.repository.mysql.JpaMysqlRepository;
import com.example.multipledb.repository.postgresql.JpaPostgresqlRepository;
import org.springframework.stereotype.Service;

@Service
public class MultipledbService {

    private final JdbcRepository jdbcRepository;
    private final JpaMysqlRepository jpaMysqlRepository;
    private final JpaPostgresqlRepository jpaPostgresqlRepository;

    public MultipledbService(JdbcRepository jdbcRepository, JpaMysqlRepository jpaMysqlRepository, JpaPostgresqlRepository jpaPostgresqlRepository) {
        this.jdbcRepository = jdbcRepository;
        this.jpaMysqlRepository = jpaMysqlRepository;
        this.jpaPostgresqlRepository = jpaPostgresqlRepository;
    }

    public String fetchNameFromMysqlByJdbc() {
        return jdbcRepository.fetchNameFromMysql();
    }

    public String fetchNameFromPostgresqlByJdbc() {
        return jdbcRepository.fetchNameFromPostgresql();
    }

    public String fetchNameFromMysqlByJpa() {
        return jpaMysqlRepository.fetchNameFromMysql();
    }

    public String fetchNameFromPostgresqlByJpa() {
        return jpaPostgresqlRepository.fetchNameFromPostgresql();
    }
}

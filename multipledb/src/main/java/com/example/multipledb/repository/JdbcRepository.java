package com.example.multipledb.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {

    @Qualifier("mysql")
    private final JdbcTemplate mysql;

    @Qualifier("postgresql")
    private final JdbcTemplate postgresql;

    public JdbcRepository(JdbcTemplate mysql, JdbcTemplate postgresql) {
        this.mysql = mysql;
        this.postgresql = postgresql;
    }

    public String fetchNameFromMysql() {
        return mysql.queryForObject("SELECT NAME FROM sample_table;", String.class);
    }

    public String fetchNameFromPostgresql() {
        return postgresql.queryForObject("SELECT NAME FROM sample_table;", String.class);
    }
}

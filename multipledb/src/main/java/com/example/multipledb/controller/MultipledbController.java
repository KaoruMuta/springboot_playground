package com.example.multipledb.controller;

import com.example.multipledb.service.MultipledbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MultipledbController {

    private final MultipledbService service;

    public MultipledbController(MultipledbService service) {
        this.service = service;
    }

    @GetMapping("jdbc/mysql")
    public Map<String, String> getJdbcMysql() {
        String name = service.fetchNameFromMysqlByJdbc();
        return Map.of("name", name);
    }

    @GetMapping("jdbc/postgresql")
    public Map<String, String> getJdbcPostgresql() {
        String name = service.fetchNameFromPostgresqlByJdbc();
        return Map.of("name", name);
    }

    @GetMapping("jpa/mysql")
    public Map<String, String> getJpaMysql() {
        String name = service.fetchNameFromMysqlByJpa();
        return Map.of("name", name);
    }

    @GetMapping("jpa/postgresql")
    public Map<String, String> getJpaPostgresql() {
        String name = service.fetchNameFromPostgresqlByJpa();
        return Map.of("name", name);
    }
}

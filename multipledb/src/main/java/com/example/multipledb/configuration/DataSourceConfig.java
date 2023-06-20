package com.example.multipledb.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("mysqlDataSource")
    @ConfigurationProperties("spring.datasource.mysql")
    @Primary
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("postgresqlDataSource")
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysql")
    public JdbcTemplate createMysqlDataSource(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("postgresql")
    public JdbcTemplate createPostgresqlDataSource(@Qualifier("postgresqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

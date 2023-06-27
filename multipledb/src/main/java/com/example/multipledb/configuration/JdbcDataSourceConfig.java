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
public class JdbcDataSourceConfig {

    @Bean("mysqlJdbcDataSource")
    @ConfigurationProperties("spring.datasource.mysql")
    @Primary
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("postgresqlJdbcDataSource")
    @ConfigurationProperties("spring.datasource.postgresql")
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysql")
    public JdbcTemplate createMysqlDataSource(@Qualifier("mysqlJdbcDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("postgresql")
    public JdbcTemplate createPostgresqlDataSource(@Qualifier("postgresqlJdbcDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

package com.example.NewsApi.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${database.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost/CityNews")
                .username("postgres")
                .password(dbPassword)
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}

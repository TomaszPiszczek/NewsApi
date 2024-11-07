package com.example.NewsApi.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class DataSourceConfig {


    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://16.170.252.4:5432/CityNews")
                .username("postgres")
                .password(SecretsManagerService.getSecretValue("dbPassword"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}

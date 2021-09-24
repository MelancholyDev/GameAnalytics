package com.simpleGame.back;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;

@Configuration
public class DBConfig {
    @Bean
    DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/analytics",
                "postgres",
               "Morrigan181");
    }



}

package com.example.spring.gradle.confing;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring.gradle.db.com.example.DatabaseProperties;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequiredArgsConstructor
@Configuration
public class JooqConfig {
    private static final Logger logger = LoggerFactory.getLogger(JooqConfig.class);
    
    private final DatabaseProperties properties;

    @Bean
    public DSLContext getDSLContext() {
        try {
        	Connection connection = DriverManager.getConnection(properties.getUrl(), properties.getUsername(), properties.getPassword());
        	return DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            logger.error("Failed to create DSLContext", e);
            throw new RuntimeException("Failed to create DSLContext", e);
        }
    }
}

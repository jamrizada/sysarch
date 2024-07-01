package com.rizada.sysarch.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseConfig {

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory() throws Exception {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://rizada:rizadapass@sysarch.ofqoylo.mongodb.net/signup?retryWrites=true&w=majority&appName=sysarch");
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "signup");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDatabaseFactory());
    }
}
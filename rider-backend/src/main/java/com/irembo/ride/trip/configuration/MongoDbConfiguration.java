package com.irembo.ride.trip.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.irembo.ride.trip")
@Configuration
public class MongoDbConfiguration extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient reactiveMongoClient() {
        return super.reactiveMongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    protected MongoClientSettings mongoClientSettings() {

        MongoClientSettings.Builder builder = MongoClientSettings.builder();
        builder.uuidRepresentation(UuidRepresentation.JAVA_LEGACY);
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        builder.applyConnectionString(connectionString);
        configureClientSettings(builder);
        return builder.build();
    }
}

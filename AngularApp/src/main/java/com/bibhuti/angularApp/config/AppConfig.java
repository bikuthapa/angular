package com.bibhuti.angularApp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
@ImportResource("classpath:SpringMongoConfiguration.xml")
public class AppConfig   {

	@Autowired
	MongoDbFactory mongoTemplate;

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoTemplate);
    }
}


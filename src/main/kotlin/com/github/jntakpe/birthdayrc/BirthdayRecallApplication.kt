package com.github.jntakpe.birthdayrc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableConfigurationProperties(MongoProperties::class)
@EnableAutoConfiguration(exclude = arrayOf(MongoAutoConfiguration::class, MongoDataAutoConfiguration::class))
class BirthdayRecallApplication

fun main(args: Array<String>) {
    SpringApplication.run(BirthdayRecallApplication::class.java, *args)
}

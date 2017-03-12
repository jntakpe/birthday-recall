package com.github.jntakpe.birthdayrc.config

import com.github.jntakpe.birthdayrc.domain.Person
import com.github.jntakpe.birthdayrc.repository.PersonRepository
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import reactor.core.publisher.Flux
import java.time.LocalDate

@Configuration
class MongoDBConfiguration() : AbstractReactiveMongoConfiguration() {

    override fun mongoClient() = MongoClients.create()

    override fun getDatabaseName() = "birthdayrc"

    @Bean
    fun initData(personRepository: PersonRepository): CommandLineRunner {
        return CommandLineRunner {
            val persons = Flux.just(
                    Person("1234567890", "Joss", LocalDate.of(1986, 9, 25)),
                    Person("1231231231", "Julie", LocalDate.of(1990, 10, 2))
            )
            personRepository.deleteAll().thenMany(personRepository.save(persons)).blockLast()
        }
    }

}
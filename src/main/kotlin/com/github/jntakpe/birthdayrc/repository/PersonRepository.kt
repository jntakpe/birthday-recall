package com.github.jntakpe.birthdayrc.repository

import com.github.jntakpe.birthdayrc.domain.Person
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : ReactiveMongoRepository<Person, String>
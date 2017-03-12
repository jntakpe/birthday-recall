package com.github.jntakpe.birthdayrc.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class Person(@Id val phone: String, val name: String, val birthday: LocalDate)
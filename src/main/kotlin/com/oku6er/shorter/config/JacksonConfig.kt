package com.oku6er.shorter.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configuration for Jackson.
 * */
@Configuration
open class JacksonConfig {
    @Bean open fun kotlinModule() = KotlinModule()
}
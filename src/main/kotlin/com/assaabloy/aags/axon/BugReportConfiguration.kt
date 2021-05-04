package com.assaabloy.aags.axon

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.axonframework.config.EventProcessingConfigurer
import org.axonframework.eventhandling.PropagatingErrorHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class BugReportConfiguration : WebMvcConfigurer, WebMvcRegistrations {

    @Autowired
    fun configure(epConfig: EventProcessingConfigurer) {
        epConfig.registerDefaultListenerInvocationErrorHandler { PropagatingErrorHandler.INSTANCE }
    }

    @Bean
    fun registerKotlinModule(): Module = KotlinModule()

    @Bean
    fun registerJavaTimeModule(): Module = JavaTimeModule()
}
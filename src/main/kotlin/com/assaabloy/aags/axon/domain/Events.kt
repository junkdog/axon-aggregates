package com.assaabloy.aags.axon.domain

data class FooCreatedEvent(
    val id: String
)

data class FooBarUpdatedEvent(
    val id: String,
    val bar: String
)
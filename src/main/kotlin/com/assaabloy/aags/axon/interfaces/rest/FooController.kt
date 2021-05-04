package com.assaabloy.aags.axon.interfaces.rest

import com.assaabloy.aags.axon.domain.BootstrapFooCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID.randomUUID

@RestController
class FooController(
    val commandGateway: CommandGateway
) {
    @PostMapping("/foo", consumes = ["application/json"])
    fun createFoo(): ResponseEntity<Any> {
        val command = BootstrapFooCommand(randomUUID().toString())
        return ResponseEntity.ok(commandGateway.sendAndWait<String>(command))
    }
}

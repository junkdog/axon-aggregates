package com.assaabloy.aags.axon

import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = ["in-memory"])
class FooTest {

    @LocalServerPort
    protected val port = 0

    @Test // works on 4.4, but not 4.5
    fun `lifecycle apply behavioral change 4_4 vs 4_5`() {
        val id = Given {
            port(port)
            contentType(ContentType.JSON)
        } When {
            post("/foo")
        } Then {
            statusCode(200)
        } Extract {
            body().asString().takeIf(String::isNotEmpty)
        }

        assertThat(id, id != null)
    }
}
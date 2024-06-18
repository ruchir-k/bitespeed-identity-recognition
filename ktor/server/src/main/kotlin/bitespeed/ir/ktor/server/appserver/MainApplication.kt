package bitespeed.ir.ktor.server.appserver

import bitespeed.ir.ktor.server.identify.IdentifyHttpService
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.withTimeout

fun main() {
    embeddedServer(Netty, port = 8080) {

        install(ContentNegotiation) {
            json()
        }


        routing {
            post("/identify") {
                withTimeout(5000) { // Timeout of 5 seconds
                }
            }
        }
    }.start(wait = true)
}
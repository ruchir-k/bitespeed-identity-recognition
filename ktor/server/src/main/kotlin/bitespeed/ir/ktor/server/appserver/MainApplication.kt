package bitespeed.ir.ktor.server.appserver

import bitespeed.ir.ktor.server.di.components.DaggerRootComponent
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.coroutines.withTimeout

fun main() {

    val rootComponent = DaggerRootComponent.create()

    embeddedServer(Netty, port = 8080) {

        install(ContentNegotiation) {
            json()
        }


        routing {
            post("/identify") {
                rootComponent.identifyHttpService.invoke(call)
            }
        }
    }.start(wait = true)
}
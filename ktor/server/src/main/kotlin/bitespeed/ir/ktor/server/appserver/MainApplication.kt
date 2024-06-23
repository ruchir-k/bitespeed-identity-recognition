package bitespeed.ir.ktor.server.appserver

import bitespeed.ir.ktor.server.di.components.DaggerRootComponent
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.withTimeout

fun main() {

    val rootComponent = DaggerRootComponent.create()

    embeddedServer(Netty, port = 8080) {

        install(ContentNegotiation) {
            json()
        }

//        install(StatusPages) {
//            exception<Throwable> { cause ->
//                call.respond(HttpStatusCode.InternalServerError, cause.localizedMessage)
//                throw cause
//            }
//        }

        routing {
            get("/") {
                call.respondText("Hello, Ktor!")
            }
            post("/identify") {
                println("/identify started")
                rootComponent.identifyHttpService.invoke(call)
                println("/identify responded")
            }
        }
    }.start(wait = true)
}
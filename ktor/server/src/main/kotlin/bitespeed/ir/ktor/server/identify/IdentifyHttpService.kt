package bitespeed.ir.ktor.server.identify

import identify.exceptions.IdentifyException
import identify.entities.IdentifyRequest
import identify.IdentifyService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import javax.inject.Inject

class IdentifyHttpService
@Inject
constructor(
    private val identifyService: IdentifyService
) {
    suspend fun invoke(call: ApplicationCall) {
        val request: IdentifyRequest = call.receive()
        try {
            val result = identifyService.invoke(request)
            call.respond(HttpStatusCode.OK, result)
        } catch (e: IdentifyException) {
            call.respond(HttpStatusCode.UnprocessableEntity, e)
        }
    }
}

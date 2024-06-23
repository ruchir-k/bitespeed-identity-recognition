package bitespeed.ir.ktor.server.identify

import bitespeed.ir.core.api.models.identify.entities.Contact
import bitespeed.ir.core.api.models.identify.entities.IdentifyRequest
import bitespeed.ir.core.api.models.identify.entities.IdentifyResponse
import bitespeed.ir.core.api.models.identify.exceptions.IdentifyException
import bitespeed.ir.core.api.service.identify.usecases.IdentifyService
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
        println("request: $request")
//        if (!isValidRequest(request)) {
//            call.respond(HttpStatusCode.BadRequest, "Invalid request")
//            return
//        }
//
//        try {
//            val result = identifyService.invoke(request)
//            call.respond(HttpStatusCode.OK, result)
//        } catch (e: IdentifyException) {
//            call.respond(HttpStatusCode.UnprocessableEntity, e)
//        }

        try {
            println("IdentifyHttpService started")
            call.respond(HttpStatusCode.OK,
                IdentifyResponse(
                    contact = Contact(
                        primaryContactId = 1,
                        emails = listOf("abc@gmail.com"),
                        phoneNumbers = listOf("1234567890"),
                        secondaryContactIds = listOf(2, 3, 4)
                    )
                )
            )
            println("IdentifyHttpService responded")
        } catch (e: Exception) {
            println("Exception while responding: ${e.message}")
        }

    }

    private fun isValidRequest(request: IdentifyRequest): Boolean {
        return request.email != null || request.phoneNumber != null
    }
}

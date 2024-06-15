package bitespeed.ir.core.api.service.identify.mappers

import bitespeed.ir.core.api.models.identify.entities.Contact
import bitespeed.ir.core.domain.identify.entities.IdentifyRequest
import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.api.models.identify.entities.IdentifyRequest as IdentifyRequestApi
import bitespeed.ir.core.api.models.identify.entities.IdentifyResponse as IdentifyResponseApi
import javax.inject.Inject

class IdentifyMapper
@Inject
constructor() {
    fun toDomain(request: IdentifyRequestApi): IdentifyRequest {
        return IdentifyRequest(
            email = request.email,
            phoneNumber = request.phoneNumber
        )
    }

    fun fromDomain(response: IdentifyResponse): IdentifyResponseApi {
        return IdentifyResponseApi(
            contact = Contact(
                primaryContactId = response.contact.primaryContactId,
                emails = response.contact.emails,
                phoneNumbers = response.contact.phoneNumbers,
                secondaryContactIds = response.contact.secondaryContactIds
            )
        )
    }
}
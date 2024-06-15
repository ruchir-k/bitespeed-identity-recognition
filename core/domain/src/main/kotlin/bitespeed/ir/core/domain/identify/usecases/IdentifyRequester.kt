package bitespeed.ir.core.domain.identify.usecases

import bitespeed.ir.core.domain.identify.entities.IdentifyRequest
import bitespeed.ir.core.domain.identify.entities.IdentifyResponse

class IdentifyRequester {
    suspend fun invoke(request: IdentifyRequest): IdentifyResponse {
        TODO()
    }
}
package bitespeed.ir.core.domain.identify.usecases

import bitespeed.ir.core.domain.identify.entities.IdentifyRequest
import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import javax.inject.Inject

class IdentifyRequester
@Inject
constructor(
    private val identifyRepo: IdentifyRepo
){
    suspend fun invoke(request: IdentifyRequest): IdentifyResponse {
        TODO()
    }
}
package bitespeed.ir.core.domain.identify.usecases

import bitespeed.ir.core.api.models.identify.exceptions.IdentifyException
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

        lateinit var response: IdentifyResponse

        if(identifyRepo.doesIdentityExist(request.email, request.phoneNumber)){

        }
        else {
            if (request.email != null && request.phoneNumber != null) {
                response = identifyRepo.createIdentity(request.email, request.phoneNumber)
            }
            else {
                throw IdentifyException("Invalid request -- Both email and phone number are required to create an identity.")
            }

        }

        return response
    }
}
package bitespeed.ir.core.domain.identify.usecases

import bitespeed.ir.core.api.models.identify.exceptions.IdentifyException
import bitespeed.ir.core.domain.identify.entities.IdentifyRequest
import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.domain.identify.entities.IdentifyType
import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import javax.inject.Inject

class IdentifyRequester
@Inject
constructor(
    private val identifyRepo: IdentifyRepo
){
    suspend fun invoke(request: IdentifyRequest): IdentifyResponse {

        lateinit var response: IdentifyResponse

        val identifyTypeWithId = identifyRepo.findIdentityType(request.email, request.phoneNumber)

        if(identifyTypeWithId.identifyType == IdentifyType.LINKED){
            response = identifyRepo.getIdentityById(identifyTypeWithId.ids!!.first())
        }
        else if(identifyTypeWithId.identifyType == IdentifyType.UNLINKED){
            response = identifyRepo.getIdentitiesByLinkedId(identifyTypeWithId.ids!!)
        }
        else if(identifyTypeWithId.identifyType == IdentifyType.NOT_PRESENT) {

            if (request.email != null && request.phoneNumber != null) {
                response = identifyRepo.createIdentity(request.email, request.phoneNumber)
            }
            else {
                throw IdentifyException("Invalid request -- Both email and phone number are " +
                        "required to create a new identity.")
            }

        }

        return response
    }
}
package bitespeed.ir.core.data.psql.repos

import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import javax.inject.Inject

class PsqlIdentifyRepo
@Inject
constructor(

): IdentifyRepo {
    override suspend fun doesIdentityExist(email: String?, phoneNumber: String?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun createIdentity(email: String, phoneNumber: String): IdentifyResponse {
        TODO("Not yet implemented")
    }
}
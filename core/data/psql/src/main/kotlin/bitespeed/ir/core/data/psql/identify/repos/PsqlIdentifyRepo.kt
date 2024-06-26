package bitespeed.ir.core.data.psql.identify.repos

import bitespeed.ir.core.data.psql.identify.IdentifyQueries
import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.domain.identify.entities.IdentifyTypeWithIds
import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import javax.inject.Inject

class PsqlIdentifyRepo
@Inject
constructor(
    private val identifyQueries: IdentifyQueries
): IdentifyRepo {
    override suspend fun findIdentityType(email: String?, phoneNumber: String?): IdentifyTypeWithIds {
        TODO("Not yet implemented")
    }

    override suspend fun createIdentity(email: String, phoneNumber: String): IdentifyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getIdentityById(id: Int): IdentifyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getIdentitiesByLinkedId(linkedIds: List<Int>): IdentifyResponse {
        TODO("Not yet implemented")
    }

}
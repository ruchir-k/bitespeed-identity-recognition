package bitespeed.ir.core.data.psql.repos

import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import javax.inject.Inject

class PsqlIdentifyRepo
@Inject
constructor(

): IdentifyRepo {
    override suspend fun doesIdentityExist(email: String?, phoneNumber: String?): Boolean {
        TODO("Not yet implemented")
    }
}
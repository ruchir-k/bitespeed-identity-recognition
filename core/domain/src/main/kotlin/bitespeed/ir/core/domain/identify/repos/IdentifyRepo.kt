package bitespeed.ir.core.domain.identify.repos

import bitespeed.ir.core.domain.identify.entities.IdentifyResponse

interface IdentifyRepo {
    suspend fun doesIdentityExist(email: String?, phoneNumber: String?): Boolean
    suspend fun createIdentity(email: String, phoneNumber: String): IdentifyResponse
}
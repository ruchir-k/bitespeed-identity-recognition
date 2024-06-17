package bitespeed.ir.core.domain.identify.repos

import bitespeed.ir.core.domain.identify.entities.IdentifyResponse
import bitespeed.ir.core.domain.identify.entities.IdentifyTypeWithIds

interface IdentifyRepo {
    suspend fun findIdentityType(email: String?, phoneNumber: String?): IdentifyTypeWithIds
    suspend fun createIdentity(email: String, phoneNumber: String): IdentifyResponse
    suspend fun getIdentityById(id: Int): IdentifyResponse
    suspend fun getIdentitiesByLinkedId(linkedIds: List<Int>): IdentifyResponse
}
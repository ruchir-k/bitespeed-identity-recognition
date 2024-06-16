package bitespeed.ir.core.domain.identify.repos

interface IdentifyRepo {
    suspend fun doesIdentityExist(email: String?, phoneNumber: String?): Boolean

}
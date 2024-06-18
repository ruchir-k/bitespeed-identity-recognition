package bitespeed.ir.core.api.models.identify.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdentifyRequest(
    @SerialName("email")
    val email: String?,
    @SerialName("phoneNumber")
    val phoneNumber: String?
)

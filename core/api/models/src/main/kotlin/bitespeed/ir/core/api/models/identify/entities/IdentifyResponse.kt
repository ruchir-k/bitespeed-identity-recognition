package bitespeed.ir.core.api.models.identify.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdentifyResponse(
    @SerialName("contact")
    val contact: Contact
)

@Serializable
data class Contact(
    val primaryContactId: Int,
    val emails: List<String>,
    val phoneNumbers: List<String>,
    val secondaryContactIds: List<Int>
)

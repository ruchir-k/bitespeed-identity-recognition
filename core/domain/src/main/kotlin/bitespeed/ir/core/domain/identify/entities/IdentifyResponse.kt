package bitespeed.ir.core.domain.identify.entities

data class IdentifyResponse(
    val contact: Contact
)

data class Contact(
    val primaryContactId: Int,
    val emails: List<String>,
    val phoneNumbers: List<String>,
    val secondaryContactIds: List<Int>
)

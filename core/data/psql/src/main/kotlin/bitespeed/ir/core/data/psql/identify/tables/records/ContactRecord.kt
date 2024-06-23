package bitespeed.ir.core.data.psql.identify.tables.records

import java.time.Instant

data class ContactRecord(
    val id: Int,
    val phoneNumber: String?,
    val email: String?,
    val linkedId: Int?,
    val linkPrecedence: String,
    val updatedAt: Instant
)
package bitespeed.ir.core.data.psql.identify.tables.mappers

import bitespeed.ir.core.data.psql.identify.tables.ContactTable
import bitespeed.ir.core.data.psql.identify.tables.records.ContactRecord
import org.jetbrains.exposed.sql.ResultRow
import javax.inject.Inject

class IdentifyMapper
@Inject
constructor(){
    fun fromResultSet(row: ResultRow) = ContactRecord(
        id = row[ContactTable.id],
        phoneNumber = row[ContactTable.phoneNumber],
        email = row[ContactTable.email],
        linkedId = row[ContactTable.linkedId],
        linkPrecedence = row[ContactTable.linkPrecedence],
        updatedAt = row[ContactTable.updatedAt]
    )
}
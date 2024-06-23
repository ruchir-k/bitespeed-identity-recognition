package bitespeed.ir.core.data.psql.identify

import bitespeed.ir.core.data.psql.identify.tables.ContactTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import javax.inject.Inject

class IdentifyQueries
@Inject
constructor(
    private val db: Database
){
    suspend fun createIdentity(email: String, phoneNumber: String) {
        ContactTable.insert {
            it[ContactTable.email] = email
            it[ContactTable.phoneNumber] = phoneNumber
            it[ContactTable.linkPrecedence] = "primary"
        }
    }
}


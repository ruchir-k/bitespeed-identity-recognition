package bitespeed.ir.core.data.psql.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object IdentityTable: Table() {
    val id = integer("id").autoIncrement()
    val email = varchar("email", 100).uniqueIndex()
    val phoneNumber = varchar("phone_number", 20).uniqueIndex()
    val linkedId = integer("linked_id").nullable()
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
    val deletedAt = datetime("deleted_at").nullable()
}
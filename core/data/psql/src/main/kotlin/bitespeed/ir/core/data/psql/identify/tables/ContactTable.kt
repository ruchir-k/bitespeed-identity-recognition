package bitespeed.ir.core.data.psql.identify.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object ContactTable : Table("Contact") {
    val id = integer("id").autoIncrement()
    val phoneNumber = varchar("phoneNumber", 20).nullable()
    val email = varchar("email", 255).nullable()
    val linkedId = integer("linkedId").nullable()
    val linkPrecedence = varchar("linkPrecedence", 10)
    val createdAt = timestamp("createdAt")
    val updatedAt = timestamp("updatedAt")
    val deletedAt = timestamp("deletedAt").nullable()

    override val primaryKey = PrimaryKey(id)

    init {
        check { linkPrecedence inList listOf("secondary", "primary") }
    }
}
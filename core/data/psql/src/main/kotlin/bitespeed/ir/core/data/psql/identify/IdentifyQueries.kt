package bitespeed.ir.core.data.psql.identify

import org.jetbrains.exposed.sql.Database
import javax.inject.Inject

class IdentifyQueries
@Inject
constructor(
    private val db: Database
){

}
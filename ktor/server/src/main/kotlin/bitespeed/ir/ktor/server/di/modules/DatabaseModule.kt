package bitespeed.ir.ktor.server.di.modules

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dagger.Module
import dagger.Provides
import org.jetbrains.exposed.sql.Database
import java.sql.SQLException
import javax.inject.Singleton
import kotlin.system.exitProcess

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideHikariDataSource(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/identity"
        config.username = "dev"
        config.password = "password"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        return HikariDataSource(config)
    }

    @Provides
    @Singleton
    fun provideDatabase(dataSource: HikariDataSource): Database {
        return try {
            dataSource.connection.use { _ ->
                Database.connect(datasource = dataSource)
            }
        } catch (e: SQLException) {
            println("Failed to connect to the database")
            e.printStackTrace()
            exitProcess(1) // Terminates the JVM
        }
    }
}
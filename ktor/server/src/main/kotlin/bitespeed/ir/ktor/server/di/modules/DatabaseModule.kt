package bitespeed.ir.ktor.server.di.modules

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import dagger.Module
import dagger.Provides
import org.jetbrains.exposed.sql.Database
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideHikariDataSource(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/identity"
        config.username = System.getenv("DB_USER") ?: "postgres"
        config.password = System.getenv("DB_PASSWORD") ?: "password"
        config.maximumPoolSize = System.getenv("DB_MAX_POOL_SIZE")?.toIntOrNull() ?: 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        return HikariDataSource(config)
    }

    @Provides
    @Singleton
    fun provideDatabase(dataSource: HikariDataSource) = Database.connect(
        datasource = dataSource
    )
}
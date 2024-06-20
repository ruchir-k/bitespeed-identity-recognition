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
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/mydatabase"
        config.username = "username"
        config.password = "password"
        config.maximumPoolSize = 3
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
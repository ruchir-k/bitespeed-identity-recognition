package bitespeed.ir.ktor.server.identify.di

import bitespeed.ir.core.data.psql.repos.PsqlIdentifyRepo
import bitespeed.ir.core.domain.identify.repos.IdentifyRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class IdentifyModule {
    @Binds
    @Singleton
    abstract fun provideIdentifyRepo(identifyRepo: PsqlIdentifyRepo): IdentifyRepo
}
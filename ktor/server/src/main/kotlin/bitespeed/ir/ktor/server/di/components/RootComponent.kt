package bitespeed.ir.ktor.server.di.components

import bitespeed.ir.ktor.server.di.modules.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class
    ]
)
interface RootComponent {
}
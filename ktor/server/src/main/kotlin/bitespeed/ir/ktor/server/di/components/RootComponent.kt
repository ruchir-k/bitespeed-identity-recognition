package bitespeed.ir.ktor.server.di.components

import bitespeed.ir.ktor.server.di.modules.DatabaseModule
import bitespeed.ir.ktor.server.identify.IdentifyHttpService
import bitespeed.ir.ktor.server.identify.di.IdentifyModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        IdentifyModule::class
    ]
)
interface RootComponent {
    val identifyHttpService: IdentifyHttpService
}
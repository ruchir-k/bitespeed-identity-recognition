package bitespeed.ir.ktor.server.di

import bitespeed.ir.ktor.server.identify.IdentifyHttpService

interface HttpComponent {
    val identifyHttpService: IdentifyHttpService
}
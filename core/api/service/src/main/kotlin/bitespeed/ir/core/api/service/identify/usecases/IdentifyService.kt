package bitespeed.ir.core.api.service.identify.usecases

import bitespeed.ir.core.api.models.identify.entities.IdentifyRequest
import bitespeed.ir.core.api.models.identify.entities.IdentifyResponse
import bitespeed.ir.core.api.service.identify.mappers.IdentifyMapper
import bitespeed.ir.core.domain.identify.usecases.IdentifyRequester
import javax.inject.Inject

class IdentifyService
@Inject
constructor(
    private val identifyRequester: IdentifyRequester,
    private val mapper: IdentifyMapper
) {
    suspend fun invoke(request: IdentifyRequest): IdentifyResponse =
        mapper.toDomain(request)
            .let { identifyRequester.invoke(it) }
            .let { mapper.fromDomain(it) }
}
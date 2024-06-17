package bitespeed.ir.core.domain.identify.entities

enum class IdentifyType {
    LINKED,
    UNLINKED,
    NOT_PRESENT
}

data class IdentifyTypeWithIds(
    val identifyType: IdentifyType,
    val ids: List<Int>? = null
)
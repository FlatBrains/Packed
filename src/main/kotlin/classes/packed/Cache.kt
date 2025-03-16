package classes.packed

import kotlinx.serialization.Serializable

@Serializable
data class Cache(
    val history: MutableList<HistoryElement>
)

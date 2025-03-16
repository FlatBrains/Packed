package classes.packed

import kotlinx.serialization.Serializable

@Serializable
data class HistoryElement( val path: String, val namespace: String )

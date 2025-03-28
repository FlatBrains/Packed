package classes.packed

import kotlinx.serialization.Serializable

@Serializable
data class HistoryElement( val path: String, val namespace: String ) {
    val fullPath = "$path/assets/$namespace"
    val json = """
        {
            "path": "$path",
            "namespace": "$namespace"
        }
    """.trimIndent()
}

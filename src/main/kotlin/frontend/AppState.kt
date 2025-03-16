package frontend

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class AppState {
    STARTUP, MAIN, LOADING
}

object App {
    var appState = mutableStateOf(AppState.STARTUP)
    var title = mutableStateOf("Packed")
}
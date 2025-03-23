package frontend

import androidx.compose.runtime.mutableStateOf

enum class AppState(val title: () -> String ) {
    HOME(   { "Packed" } ),
    MAIN(   { "Packed: ${backend.Backend.Pack.name}@${backend.Backend.Pack.namespace}" } ),
    LOADING({ "Packed: Loading" } ),
}

object App {
    var appState = mutableStateOf(AppState.HOME)
    var title = mutableStateOf("Packed")
    
    fun setState(state: AppState) {
        appState.value = state
        title.value = state.title()
    }
}
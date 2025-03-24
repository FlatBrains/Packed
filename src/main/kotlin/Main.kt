
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowExceptionHandler
import androidx.compose.ui.window.application
import backend.Backend
import backend.debug.logger
import frontend.App
import frontend.AppState
import frontend.Icon
import frontend.menus.EditorScreen
import frontend.menus.HomeScreen
import frontend.menus.LoadingScreen
import java.awt.Dimension

@OptIn(ExperimentalComposeUiApi::class)
fun main(): Unit = application {
    
    Window(
        onCloseRequest = ::exitApplication,
        title = App.title.value,
        icon = Icon.Packed.painter(),
        resizable = true,
    ) {
        window.minimumSize = Dimension(1200, 600)
        window.exceptionHandler = WindowExceptionHandler { logger.severe(it.message); it.printStackTrace() }
        
        Backend // init
        
        
        when(App.appState.value) {
            AppState.HOME -> HomeScreen()
            AppState.MAIN -> EditorScreen()
            AppState.LOADING -> LoadingScreen()
        }

    }
}

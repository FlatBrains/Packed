
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowExceptionHandler
import androidx.compose.ui.window.application
import backend.Backend
import backend.debug.logger
import frontend.App
import frontend.AppState
import frontend.menus.EditorScreen
import frontend.menus.HomeScreen
import frontend.menus.LoadingScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import packed.Res
import packed.packed
import java.awt.Dimension

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main(): Unit = application {
    
    Backend // init
    
    Window(
        onCloseRequest = ::exitApplication,
        title = App.title.value,
        icon = painterResource(Res.drawable.packed),
        resizable = true,
    ) {
        
        window.minimumSize = Dimension(1200, 600)
        window.exceptionHandler = WindowExceptionHandler { logger.severe(it.message); it.printStackTrace() }
        
        when(App.appState.value) {
            AppState.HOME -> HomeScreen()
            AppState.MAIN -> EditorScreen()
            AppState.LOADING -> LoadingScreen()
        }
    }
}

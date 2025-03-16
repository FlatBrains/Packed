import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowExceptionHandler
import androidx.compose.ui.window.application
import backend.Backend
import backend.debug.logger
import frontend.App
import frontend.AppState
import frontend.Icon
import frontend.menus.LoadingScreen
import frontend.menus.MainMenu
import frontend.menus.OpenNewPackMenu
import java.awt.Dimension


@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = App.title.value,
        icon = Icon.Packed.painter(),
        resizable = true,
    ) {
        window.minimumSize = Dimension(800, 600)
        window.exceptionHandler = WindowExceptionHandler { logger.severe(it.message); it.printStackTrace() }


        Backend // init


        when(App.appState.value) {
            AppState.STARTUP -> OpenNewPackMenu()
            AppState.MAIN -> MainMenu()
            AppState.LOADING -> LoadingScreen()
        }


    }
}

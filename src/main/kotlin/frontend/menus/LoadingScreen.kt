package frontend.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import frontend.Icon
import frontend.Mocha
import org.jetbrains.skia.Surface


@Composable
fun LoadingScreen() {
    Surface(color = Mocha.Crust) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(Icon.PackedWhite.painter(), null, Modifier.fillMaxSize(0.5F))

        }
    }
}
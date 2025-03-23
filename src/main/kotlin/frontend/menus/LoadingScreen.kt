package frontend.menus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import frontend.Icon
import frontend.Mocha


@Composable
fun LoadingScreen() {
    Surface(color = Mocha.Crust) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            //Image(Icon, null, Modifier.fillMaxSize(0.5F))
            
            Icon.PackedWhite.toImage(modifier = Modifier.fillMaxSize(0.5F))

        }
    }
}
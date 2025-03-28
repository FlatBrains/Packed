package frontend.menus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import frontend.Mocha
import frontend.components.Image
import packed.Res
import packed.packed_white


@Composable
fun LoadingScreen() {
    Surface(color = Mocha.Crust) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            
            Image(Res.drawable.packed_white, modifier = Modifier.fillMaxSize(0.5F))

        }
    }
}
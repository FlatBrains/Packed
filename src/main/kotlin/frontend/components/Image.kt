package frontend.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import frontend.Icon

@Composable
fun Image(
    source: ImageVector,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(source, description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}

@Composable
fun Image(
    source: Painter,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(source, description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}

@Composable
fun Image(
    source: ImageBitmap,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(source, description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}

@Composable
fun Image(
    source: Icon,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(source.painter(), description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}
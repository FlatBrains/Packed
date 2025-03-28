package frontend.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

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
    source: DrawableResource,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(painterResource(source), description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}

/*
@Composable
fun Image(
    source: Painter,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(source, description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}

@OptIn(ExperimentalResourceApi::class)
fun drawableResource(id: String): DrawableResource {
    
    //logger.info(File(Res.getUri("drawable/packed.svg")).exists().toString())
    
    return Res.allDrawableResources[id]!!
}


@Composable
fun Image(
    source: String,
    description: String? = null,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    return Image(painterResource(drawableResource(source)), description, colorFilter = ColorFilter.tint(color = color), modifier = modifier)
}
*/
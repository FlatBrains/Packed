package frontend

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


object Mocha {
    val Rosewater = Color(0xFFF5E0DC)
    val Flamingo = Color(0xFFF2CDCD)
    val Pink = Color(0xFFF5C2E7)
    val Mauve = Color(0xFFCBA6F7)
    val Red = Color(0xFFF38BA8)
    val Maroon = Color(0xFFEBA0AC)
    val Peach = Color(0xFFFAB387)
    val Yellow = Color(0xFFF9E2AF)
    val Green = Color(0xFFA6E3A1)
    val Teal = Color(0xFF94E2D5)
    val Sky = Color(0xFF89DCEB)
    val Sapphire = Color(0xFF74C7EC)
    val Blue = Color(0xFF89B4FA)
    val Lavender = Color(0xFFB4BEFE)
    val Text = Color(0xFFCDD6F4)
    val Subtext1 = Color(0xFFBAC2DE)
    val Subtext0 = Color(0xFFA6ADC8)
    val Overlay2 = Color(0xFF9399B2)
    val Overlay1 = Color(0xFF7F849C)
    val Overlay0 = Color(0xFF6C7086)
    val Surface2 = Color(0xFF585B70)
    val Surface1 = Color(0xFF45475A)
    val Surface0 = Color(0xFF313244)
    val Base = Color(0xFF1E1E2E)
    val Mantle = Color(0xFF181825)
    val Crust = Color(0xFF11111B)
}

val DarkColorPalette = darkColors(
    primary = Mocha.Red,
    primaryVariant = Mocha.Maroon,
    secondary = Mocha.Peach,
    background = Mocha.Base,
    surface = Mocha.Mantle,
    error = Mocha.Red,
    onPrimary = Mocha.Base,
    onSecondary = Mocha.Base,
    onBackground = Mocha.Text,
    onSurface = Mocha.Text,
    onError = Mocha.Base
)

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(0.dp)
)

val JetBrainsMono = FontFamily(
    Font("fonts/JetBrainsMono-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
    Font("fonts/JetBrainsMono-BoldItalic.ttf", FontWeight.Bold, FontStyle.Italic),
    Font("fonts/JetBrainsMono-ExtraBold.ttf", FontWeight.ExtraBold, FontStyle.Normal),
    Font("fonts/JetBrainsMono-ExtraBoldItalic.ttf", FontWeight.ExtraBold, FontStyle.Italic),
    Font("fonts/JetBrainsMono-ExtraLight.ttf", FontWeight.ExtraLight, FontStyle.Normal),
    Font("fonts/JetBrainsMono-ExtraLightItalic.ttf", FontWeight.ExtraLight, FontStyle.Italic),
    Font("fonts/JetBrainsMono-Italic.ttf", FontWeight.Normal, FontStyle.Italic),
    Font("fonts/JetBrainsMono-Light.ttf", FontWeight.Light, FontStyle.Normal),
    Font("fonts/JetBrainsMono-LightItalic.ttf", FontWeight.Light, FontStyle.Italic),
    Font("fonts/JetBrainsMono-Medium.ttf", FontWeight.Medium, FontStyle.Normal),
    Font("fonts/JetBrainsMono-MediumItalic.ttf", FontWeight.Medium, FontStyle.Italic),
    Font("fonts/JetBrainsMono-Regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font("fonts/JetBrainsMono-SemiBold.ttf", FontWeight.SemiBold, FontStyle.Normal),
    Font("fonts/JetBrainsMono-SemiBoldItalic.ttf", FontWeight.SemiBold, FontStyle.Italic),
    Font("fonts/JetBrainsMono-Thin.ttf", FontWeight.Thin, FontStyle.Normal),
    Font("fonts/JetBrainsMono-ThinItalic.ttf", FontWeight.Thin, FontStyle.Italic)
)

val Typography = Typography(
    defaultFontFamily = JetBrainsMono,
    
    button = TextStyle(
        fontFamily = JetBrainsMono,
        color = Mocha.Text
    ),
    h1 = TextStyle(
        fontFamily = JetBrainsMono,
        color = Mocha.Text,
        fontSize = 32.sp
    ),
    
    body1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = JetBrainsMono,
        color = Mocha.Text,
    ),
    
    subtitle1 = TextStyle(
        fontFamily = JetBrainsMono,
        color = Mocha.Overlay1
    )

)
/*

@Suppress("DEPRECATION")
@Composable
fun getIcon(path: String): Painter {
    return painterResource("images/$path")
}
*/



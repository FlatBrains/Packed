package frontend.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import frontend.Mocha

@Composable
fun ContextMenuButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    label: String,
    icon: ImageVector,
    theme: Color = Mocha.Text,
    onClick: () -> Unit,
) {
    return ContextMenuButton(
        onClick, modifier, enabled, interactionSource, elevation, shape, border, colors,
        { Image(icon, color = theme) },
        { Text(label, color = theme) },
    )
}

@Composable
fun ContextMenuButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    label: @Composable () -> Unit,
    icon: @Composable () -> Unit,
) {
    TextButton(
        onClick, modifier.fillMaxWidth(), enabled,
        interactionSource, elevation, shape,
        border, colors
    ) {
        icon()
        Spacer(Modifier.width(10.dp))
        label()
        Spacer(Modifier.weight(1F))
    }
}

class ContextMenuScope(val dismiss: () -> Unit ) {
    
    @Composable
    fun Button(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionSource: MutableInteractionSource? = null,
        elevation: ButtonElevation? = null,
        shape: Shape = MaterialTheme.shapes.small,
        border: BorderStroke? = null,
        colors: ButtonColors = ButtonDefaults.textButtonColors(),
        label: @Composable () -> Unit,
        icon: @Composable () -> Unit,
    ) {
        return ContextMenuButton(
            { onClick(); dismiss() }, modifier, enabled, interactionSource, elevation, shape, border, colors, icon, label
        )
    }
    
    
    @Composable
    fun Button(
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        interactionSource: MutableInteractionSource? = null,
        elevation: ButtonElevation? = null,
        shape: Shape = MaterialTheme.shapes.small,
        border: BorderStroke? = null,
        colors: ButtonColors = ButtonDefaults.textButtonColors(),
        label: String,
        icon: ImageVector,
        theme: Color = Mocha.Text,
        onClick:  () -> Unit,
    ) {
        return this.Button(
            onClick, modifier, enabled, interactionSource, elevation, shape, border, colors,
            { Image(icon, color = theme) },
            { Text(label, color = theme) },
        )
    }
    
    @Composable
    fun SplitButton(
        button1: @Composable () -> Unit,
        button2: @Composable () -> Unit,
        modifier: Modifier = Modifier,
    ) {
        
        Row(modifier.fillMaxWidth()) {
            Box(Modifier.weight(1F).fillMaxWidth().height(50.dp)) { button1() }
            Box(Modifier.weight(1F).fillMaxWidth().height(50.dp)) { button2() }
        }

    }
}
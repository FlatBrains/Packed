package frontend.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier,
    columnModifier: Modifier = Modifier,
    scrollbarModifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {
    // Create and remember the scroll state
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier.fillMaxSize(),

    ) {
        // The scrollable Column. It fills available space.
        Column(
            content = content,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            modifier = columnModifier
                .verticalScroll(scrollState)
                .padding(end = 15.dp)
                .fillMaxWidth()
        )



        // The vertical scrollbar is drawn on top, aligned to the end (right side)
        VerticalScrollbar(
            adapter = rememberScrollbarAdapter(scrollState),
            modifier = scrollbarModifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(15.dp)
        )
    }
}
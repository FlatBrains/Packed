package frontend.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ScrollableLazyColumn(
    modifier: Modifier = Modifier,
    columnModifier: Modifier = Modifier,
    scrollbarModifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    state: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // The scrollable Column. It fills available space.
        LazyColumn(
            state = state,
            content = content,
            modifier = columnModifier
                .padding(end = 15.dp),
            contentPadding = contentPadding
        )



        // The vertical scrollbar is drawn on top, aligned to the end (right side)
        VerticalScrollbar(
            adapter = rememberScrollbarAdapter(state),
            modifier = scrollbarModifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(15.dp)
        )
    }
}
package backend.utilities

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

fun copyToClipboard(string: String) {
    Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(string), null)
}


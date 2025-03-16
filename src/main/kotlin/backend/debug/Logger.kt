package backend.debug

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Formatter
import java.util.logging.LogRecord
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("Packed")

object LogFormatter : Formatter() {
    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    @Synchronized
    override fun format(record: LogRecord): String {
        val time = dateFormat.format(Date(record.millis))
        return String.format("[%s] %s: %s%n", time, record.level, record.message)
    }
}


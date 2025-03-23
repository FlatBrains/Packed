package classes.compose

typealias listener = () -> Unit

class Signal() {
    
    val listeners: MutableList<listener> = mutableListOf()
    
    fun trigger() {
        listeners.forEach {
            it.invoke()
        }
    }
    
    fun on(listener: listener) { listeners.add(listener) }
    
    companion object {
        fun on(signal: Signal, listener: listener) {
            signal.listeners.add(listener)
        }
    }
}


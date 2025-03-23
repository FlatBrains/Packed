package frontend.menus.test

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import backend.debug.logger
import classes.compose.Signal

@Composable
fun SignalTest() {
    // Remember the Signal instance with an initial value
    val signal = Signal()
    
    MaterialTheme {
        // Button that triggers the signal's state change
        Button(onClick = { signal.trigger() }) {
            Text("Trigger Signal")
        }
        
        // LaunchEffect that triggers whenever 'signal' changes
        signal.on {
            // Side effect to show the popup whenever 'signal' changes
            
            logger.info("Signal triggered!")
        }
    }

}
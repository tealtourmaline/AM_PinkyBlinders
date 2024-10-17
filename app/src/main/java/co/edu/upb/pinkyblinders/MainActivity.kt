package co.edu.upb.pinkyblinders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import co.edu.upb.pinkyblinders.navigation.AppNavigation
import co.edu.upb.pinkyblinders.ui.theme.PinkyBlindersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PinkyBlindersTheme {
                // Pasa el contexto a AppNavigation
                AppNavigation(context = this)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PinkyBlindersTheme {
        // Pasa el contexto a AppNavigation en la previsualización
        AppNavigation(context = LocalContext.current)

    }
}


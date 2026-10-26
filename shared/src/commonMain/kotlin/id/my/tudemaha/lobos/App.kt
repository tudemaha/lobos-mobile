package id.my.tudemaha.lobos


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import id.my.tudemaha.lobos.ui.navigation.LobosNavHost
import id.my.tudemaha.lobos.ui.theme.LobosTheme

@Composable
fun App() {
    LobosTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            LobosNavHost()
        }
    }
}
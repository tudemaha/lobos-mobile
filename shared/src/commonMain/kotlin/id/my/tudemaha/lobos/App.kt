package id.my.tudemaha.lobos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.my.tudemaha.lobos.ui.screens.LoginScreen
import id.my.tudemaha.lobos.ui.theme.LobosTheme
import org.jetbrains.compose.resources.painterResource

import lobos_mobile.shared.generated.resources.Res
import lobos_mobile.shared.generated.resources.compose_multiplatform

@Composable
fun App() {
    LobosTheme {
        LoginScreen()
    }
}
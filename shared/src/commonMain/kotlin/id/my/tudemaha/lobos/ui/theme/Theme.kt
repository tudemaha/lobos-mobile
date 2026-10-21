package id.my.tudemaha.lobos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PastelBlue,
    primaryContainer = PastelBlueLight,
    surface = SurfaceLight,
    onPrimary = Color.White,
    onSurface = TextPrimary,
    error = ErrorColor,
)

private val DarkColorScheme = darkColorScheme(
    primary = PastelBlue,
    primaryContainer = PastelBlueDark,
    surface = Color(0xFF121212),
    onPrimary = Color.White,
    onSurface = Color.White,
    error = ErrorColor,
)

@Composable
fun LobosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
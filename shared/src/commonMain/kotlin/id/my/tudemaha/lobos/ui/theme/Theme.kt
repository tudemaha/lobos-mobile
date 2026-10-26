package id.my.tudemaha.lobos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PastelBlue,
    onPrimary = Color.White,
    primaryContainer = PastelBlueLight,
    onPrimaryContainer = Gray900,
    secondary = Gray700,
    onSecondary = Color.White,
    background = Gray50,
    onBackground = Gray900,
    surface = Color.White,
    onSurface = Gray900,
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray500,
    outline = Gray300,
    outlineVariant = Gray200,
    error = ErrorRed,
    onError = Color.White,
)

private val DarkColorScheme = darkColorScheme(
    primary = PastelBlue,
    onPrimary = Color.White,
    primaryContainer = PastelBlueHover,
    onPrimaryContainer = Color.White,
    secondary = Gray300,
    onSecondary = Gray900,
    background = Gray900,
    onBackground = Gray50,
    surface = Gray800,
    onSurface = Gray50,
    surfaceVariant = Gray700,
    onSurfaceVariant = Gray400,
    outline = Gray500,
    outlineVariant = Gray700,
    error = ErrorRed,
    onError = Color.White,
)

@Composable
fun LobosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = lobosTypography(),
        content = content
    )
}
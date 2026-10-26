package id.my.tudemaha.lobos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import lobos_mobile.shared.generated.resources.Res
import lobos_mobile.shared.generated.resources.eb_garamond_bold
import lobos_mobile.shared.generated.resources.eb_garamond_medium
import lobos_mobile.shared.generated.resources.eb_garamond_regular
import lobos_mobile.shared.generated.resources.eb_garamond_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun lobosFontFamily(): FontFamily = FontFamily(
    Font(Res.font.eb_garamond_regular, FontWeight.Normal),
    Font(Res.font.eb_garamond_medium, FontWeight.Medium),
    Font(Res.font.eb_garamond_semibold, FontWeight.SemiBold),
    Font(Res.font.eb_garamond_bold, FontWeight.Bold),
)

@Composable
fun lobosTypography(): Typography {
    val fontFamily = lobosFontFamily()
    val defaultTypography = Typography()

    return Typography(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = defaultTypography.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = defaultTypography.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = fontFamily),
    )
}
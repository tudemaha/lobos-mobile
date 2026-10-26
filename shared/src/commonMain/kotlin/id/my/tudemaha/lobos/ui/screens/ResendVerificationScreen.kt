package id.my.tudemaha.lobos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import id.my.tudemaha.lobos.presentation.auth.ResendVerificationUiState
import id.my.tudemaha.lobos.presentation.auth.ResendVerificationViewModel
import id.my.tudemaha.lobos.ui.components.AuthHeader
import id.my.tudemaha.lobos.ui.components.ErrorMessage
import id.my.tudemaha.lobos.ui.components.LobosButton
import id.my.tudemaha.lobos.ui.theme.LobosTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ResendVerificationScreen(
    email: String,
    viewModel: ResendVerificationViewModel = koinViewModel(),
    onNavigateToLogin: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ResentVerificationContent(
        uiState = uiState,
        email = email,
        onResendVerificationClick = { viewModel.resendVerificationEmail(email) },
        onLoginClick = onNavigateToLogin
    )
}

@Composable
fun ResentVerificationContent(
    uiState: ResendVerificationUiState,
    email: String,
    onResendVerificationClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthHeader(
                title = "Verify your email",
                subtitle = "Check your inbox to activate your account"
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("We've sent a verification link to ")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                append(email)
                            }
                            append(". Please check your inbox and click the link to activate your account.")
                        },
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    ErrorMessage(message = uiState.errorMessage)
                    if (uiState.infoMessage != null) {
                        Text(
                            text = uiState.infoMessage,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    LobosButton(
                        text = "Resend Verification Email",
                        onClick = onResendVerificationClick,
                        isLoading = uiState.isLoading
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    TextButton(onClick = onLoginClick) {
                        Text(text = "Back to Sign In")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ResentVerificationContentPreview() {
    LobosTheme {
        ResentVerificationContent(
            uiState = ResendVerificationUiState(),
            email = "user@example.com",
            onResendVerificationClick = {},
            onLoginClick = {}
        )
    }
}

@Preview
@Composable
private fun ResentVerificationContentInfoPreview() {
    LobosTheme {
        ResentVerificationContent(
            uiState = ResendVerificationUiState(
                infoMessage = "Verification email has been resent!"
            ),
            email = "user@example.com",
            onResendVerificationClick = {},
            onLoginClick = {}
        )
    }
}

@Preview
@Composable
private fun ResentVerificationContentErrorPreview() {
    LobosTheme {
        ResentVerificationContent(
            uiState = ResendVerificationUiState(
                errorMessage = "Failed to resend verification email."
            ),
            email = "user@example.com",
            onResendVerificationClick = {},
            onLoginClick = {}
        )
    }
}

@Preview
@Composable
private fun ResentVerificationContentLoadingPreview() {
    LobosTheme {
        ResentVerificationContent(
            uiState = ResendVerificationUiState(
                isLoading = true
            ),
            email = "user@example.com",
            onResendVerificationClick = {},
            onLoginClick = {}
        )
    }
}
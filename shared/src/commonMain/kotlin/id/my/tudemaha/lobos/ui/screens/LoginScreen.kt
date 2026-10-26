package id.my.tudemaha.lobos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import id.my.tudemaha.lobos.presentation.auth.LoginUiState
import id.my.tudemaha.lobos.presentation.auth.LoginViewModel
import id.my.tudemaha.lobos.ui.components.AuthHeader
import id.my.tudemaha.lobos.ui.components.ErrorMessage
import id.my.tudemaha.lobos.ui.components.LobosButton
import id.my.tudemaha.lobos.ui.components.LobosPasswordField
import id.my.tudemaha.lobos.ui.components.LobosTextField
import id.my.tudemaha.lobos.ui.theme.LobosTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onNavigateToRegister: () -> Unit = {},
    onLoginSuccess: () -> Unit = {},
    onNavigateToResendVerification: (email: String) -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onLoginSuccess()
        }
    }

    LaunchedEffect(uiState.isEmailNotVerified) {
        if (uiState.isEmailNotVerified) {
            viewModel.onEmailNotVerifiedHandled()
            onNavigateToResendVerification(uiState.email.trim())
        }
    }

    LoginContent(
        uiState = uiState,
        onEmailChange = viewModel::onEmailChanges,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = viewModel::login,
        onRegisterClick = onNavigateToRegister
    )
}

@Composable
fun LoginContent(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
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
                title = "Welcome back",
                subtitle = "Sign in to your Lobos account"
            )

            ErrorMessage(message = uiState.errorMessage)

            LobosTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                label = "Email",
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(16.dp))
            LobosPasswordField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                label = "Password"
            )
            Spacer(modifier = Modifier.height(24.dp))

            LobosButton(
                text = "Log In",
                onClick = onLoginClick,
                isLoading = uiState.isLoading
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onRegisterClick) {
                Text(text = "Don't have an account? Register")
            }
        }
    }
}

@Preview
@Composable
private fun LoginContentPreview() {
    LobosTheme {
        LoginContent(
            uiState = LoginUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}

@Preview
@Composable
private fun LoginContentErrorPreview() {
    LobosTheme {
        LoginContent(
            uiState = LoginUiState(
                email = "user@example.com",
                errorMessage = "Invalid email or password"
            ),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}

@Preview
@Composable
private fun LoginContentLoadingPreview() {
    LobosTheme {
        LoginContent(
            uiState = LoginUiState(
                email = "user@example.com",
                isLoading = true
            ),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}
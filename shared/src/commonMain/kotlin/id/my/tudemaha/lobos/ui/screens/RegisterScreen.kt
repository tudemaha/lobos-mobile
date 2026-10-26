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
import id.my.tudemaha.lobos.presentation.auth.RegisterUiState
import id.my.tudemaha.lobos.presentation.auth.RegisterViewModel
import id.my.tudemaha.lobos.ui.components.AuthHeader
import id.my.tudemaha.lobos.ui.components.ErrorMessage
import id.my.tudemaha.lobos.ui.components.LobosButton
import id.my.tudemaha.lobos.ui.components.LobosPasswordField
import id.my.tudemaha.lobos.ui.components.LobosTextField
import id.my.tudemaha.lobos.ui.theme.LobosTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: (email: String) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onRegisterSuccess(uiState.email)
        }
    }

    RegisterContent(
        uiState = uiState,
        onFirstNameChange = viewModel::onFirstNameChanges,
        onLastNameChange = viewModel::onLastNameChanges,
        onEmailChange = viewModel::onEmailChanges,
        onPasswordChange = viewModel::onPasswordChanges,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChanges,
        onRegisterClick = viewModel::register,
        onLoginClick = onNavigateToLogin
    )
}

@Composable
fun RegisterContent(
    uiState: RegisterUiState,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit,
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
                title = "Create account",
                subtitle = "Start organizing your grammar collections"
            )

            ErrorMessage(message = uiState.errorMessage)

            LobosTextField(
                value = uiState.firstName,
                onValueChange = onFirstNameChange,
                label = "First Name"
            )
            Spacer(modifier = Modifier.height(16.dp))
            LobosTextField(
                value = uiState.lastName,
                onValueChange = onLastNameChange,
                label = "Last Name"
            )
            Spacer(modifier = Modifier.height(16.dp))
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
            Spacer(modifier = Modifier.height(16.dp))
            LobosPasswordField(
                value = uiState.confirmPassword,
                onValueChange = onConfirmPasswordChange,
                label = "Password Confirmation"
            )
            Spacer(modifier = Modifier.height(24.dp))

            LobosButton(
                text = "Create Account",
                onClick = onRegisterClick,
                isLoading = uiState.isLoading
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onLoginClick) {
                Text(text = "Already have an account? Sign In")
            }
        }
    }
}

@Preview
@Composable
private fun RegisterContentPreview() {
    LobosTheme {
        RegisterContent(
            uiState = RegisterUiState(),
            onFirstNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onRegisterClick = {},
            onLoginClick = {},
        )
    }
}

@Preview
@Composable
private fun RegisterContentErrorPreview() {
    LobosTheme {
        RegisterContent(
            uiState = RegisterUiState(
                firstName = "John",
                lastName = "Doe",
                email = "john@example.com",
                errorMessage = "Passwords do not match"
            ),
            onFirstNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onRegisterClick = {},
            onLoginClick = {}
        )
    }
}

@Preview
@Composable
private fun RegisterContentLoadingPreview() {
    LobosTheme {
        RegisterContent(
            uiState = RegisterUiState(
                firstName = "John",
                lastName = "Doe",
                email = "john@example.com",
                isLoading = true
            ),
            onFirstNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onRegisterClick = {},
            onLoginClick = {}
        )
    }
}
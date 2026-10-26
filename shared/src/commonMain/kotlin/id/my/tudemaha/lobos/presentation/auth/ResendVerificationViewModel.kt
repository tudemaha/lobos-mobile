package id.my.tudemaha.lobos.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.my.tudemaha.lobos.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResendVerificationViewModel(
    private val authRepository: AuthRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ResendVerificationUiState())
    val uiState = _uiState.asStateFlow()

    fun resendVerificationEmail(email: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            val result = authRepository.resendVerification(email)
            result.fold(
                onSuccess = {
                    _uiState.update { it.copy(isLoading = false, infoMessage = "Verification email has been resent!") }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Failed to resend varification email."
                    ) }
                }
            )
        }
    }
}
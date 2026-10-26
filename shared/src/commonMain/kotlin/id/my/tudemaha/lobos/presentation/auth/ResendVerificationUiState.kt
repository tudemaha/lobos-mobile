package id.my.tudemaha.lobos.presentation.auth

data class ResendVerificationUiState(
    val isLoading: Boolean = false,
    val infoMessage: String? = null,
    val errorMessage: String? = null,
)
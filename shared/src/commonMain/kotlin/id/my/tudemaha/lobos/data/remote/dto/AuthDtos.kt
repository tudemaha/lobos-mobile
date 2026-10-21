package id.my.tudemaha.lobos.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserLoginRequest(
    val email: String,
    val password: String,
    val rememberMe: Boolean = true
) {
}

@Serializable
data class UserRegisterRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
)

@Serializable
data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)

@Serializable
data class RefreshRequest(
    val refreshToken: String
)

@Serializable
data class ResendVerificationRequest(
    val email: String,
)
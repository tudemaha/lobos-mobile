package id.my.tudemaha.lobos.data.repository

import id.my.tudemaha.lobos.data.remote.LobosAuthApi
import id.my.tudemaha.lobos.data.remote.dto.ResendVerificationRequest
import id.my.tudemaha.lobos.data.remote.dto.UserLoginRequest
import id.my.tudemaha.lobos.data.remote.dto.UserRegisterRequest
import id.my.tudemaha.lobos.domain.model.AuthToken
import id.my.tudemaha.lobos.domain.model.LoginData
import id.my.tudemaha.lobos.domain.model.RegisterData
import id.my.tudemaha.lobos.domain.repository.AuthRepository
import id.my.tudemaha.lobos.platform.TokenStore

class AuthRepositoryImpl(
    private val authApi: LobosAuthApi,
    private val tokenStore: TokenStore
): AuthRepository {
    override suspend fun login(data: LoginData): Result<AuthToken> {
        return try {
            val request = UserLoginRequest(
                data.email,
                data.password,
            )
            val response = authApi.login(request)
            if (response.success && response.data != null) {
                val token = AuthToken(
                    accessToken = response.data.accessToken,
                    refreshToken = response.data.refreshToken
                )
                tokenStore.saveTokens(token)
                Result.success(token)
            } else {
                val errorMessage = response.errors?.firstOrNull() ?: response.code ?: "Login failed"
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(data: RegisterData): Result<Unit> {
        return try {
            val request = UserRegisterRequest(
                firstName = data.firstName,
                lastName = data.lastName,
                email = data.email,
                password = data.password,
                confirmPassword = data.confirmPassword
            )
            val response = authApi.register(request)
            if (response.success) {
                Result.success(Unit)
            } else {
                val errorMessage = response.errors?.firstOrNull() ?: response.code ?: "Registration failed"
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun resendVerification(email: String): Result<Unit> {
        return try {
            val response = authApi.resendVerification(ResendVerificationRequest(email = email))
            if (response.success) {
                Result.success(Unit)
            } else {
                val errorMessage = response.errors?.firstOrNull() ?: response.code ?: "Resend verification failed"
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getSavedTokens(): AuthToken? = tokenStore.getTokens()

    override fun isLoggedIn(): Boolean = tokenStore.getTokens() != null

    override suspend fun logout(): Result<Unit> {
        tokenStore.clearTokens()
        return Result.success(Unit)
    }
}
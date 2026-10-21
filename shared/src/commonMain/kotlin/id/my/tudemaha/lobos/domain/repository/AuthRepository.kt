package id.my.tudemaha.lobos.domain.repository

import id.my.tudemaha.lobos.domain.model.AuthToken
import id.my.tudemaha.lobos.domain.model.LoginData
import id.my.tudemaha.lobos.domain.model.RegisterData

interface AuthRepository {
    suspend fun login(data: LoginData): Result<AuthToken>
    suspend fun register(data: RegisterData): Result<Unit>
    suspend fun resendVerification(email: String): Result<Unit>
    fun getSavedTokens(): AuthToken?
    fun isLoggedIn(): Boolean
    suspend fun logout(): Result<Unit>
}
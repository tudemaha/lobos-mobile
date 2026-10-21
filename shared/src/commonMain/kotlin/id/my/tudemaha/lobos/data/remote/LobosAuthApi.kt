package id.my.tudemaha.lobos.data.remote

import id.my.tudemaha.lobos.data.remote.dto.ApiResponse
import id.my.tudemaha.lobos.data.remote.dto.RefreshRequest
import id.my.tudemaha.lobos.data.remote.dto.ResendVerificationRequest
import id.my.tudemaha.lobos.data.remote.dto.TokenResponse
import id.my.tudemaha.lobos.data.remote.dto.UserLoginRequest
import id.my.tudemaha.lobos.data.remote.dto.UserRegisterRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class LobosAuthApi(
    private val client: HttpClient
) {
    suspend fun login(request: UserLoginRequest): ApiResponse<TokenResponse> {
        return client.post("/api/auth/login") {
            setBody(request)
        }.body()
    }

    suspend fun register(request: UserRegisterRequest): ApiResponse<Unit> {
        return client.post("/api/auth/register") {
            setBody(request)
        }.body()
    }

    suspend fun resendVerification(request: ResendVerificationRequest): ApiResponse<Unit> {
        return client.post("/api/auth/resend-verification") {
            setBody(request)
        }.body()
    }

    suspend fun refreshToken(request: RefreshRequest): ApiResponse<TokenResponse> {
        return client.post("/api/auth/refresh") {
            setBody(request)
        }.body()
    }
}
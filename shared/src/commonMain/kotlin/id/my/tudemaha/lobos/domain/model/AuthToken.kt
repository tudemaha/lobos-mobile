package id.my.tudemaha.lobos.domain.model

data class AuthToken(
    val accessToken: String,
    val refreshToken: String
)
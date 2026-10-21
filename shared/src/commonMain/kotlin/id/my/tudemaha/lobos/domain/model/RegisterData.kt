package id.my.tudemaha.lobos.domain.model

data class RegisterData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
)
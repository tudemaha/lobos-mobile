package id.my.tudemaha.lobos.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val code: String? = null,
    val data: T? = null,
    val errors: List<String>? = null
)

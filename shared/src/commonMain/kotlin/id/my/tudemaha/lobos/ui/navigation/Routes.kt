package id.my.tudemaha.lobos.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute

@Serializable
data object RegisterRoute

@Serializable
data class ResendVerificationRoute(val email: String)

@Serializable
data object HomeRoute
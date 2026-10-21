package id.my.tudemaha.lobos.platform

import id.my.tudemaha.lobos.domain.model.AuthToken

interface TokenStore {
    fun saveTokens(tokens: AuthToken)
    fun getTokens(): AuthToken?
    fun clearTokens()
}
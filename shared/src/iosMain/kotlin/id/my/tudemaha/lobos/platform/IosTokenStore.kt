package id.my.tudemaha.lobos.platform

import id.my.tudemaha.lobos.domain.model.AuthToken
import platform.Foundation.NSUserDefaults

class IosTokenStore: TokenStore {
    private val defaults = NSUserDefaults.standardUserDefaults

    override fun saveTokens(tokens: AuthToken) {
        defaults.setObject(tokens.accessToken, forKey = KEY_ACCESS_TOKEN)
        defaults.setObject(tokens.refreshToken, forKey = KEY_REFRESH_TOKEN)
    }

    override fun getTokens(): AuthToken? {
        val access = defaults.stringForKey(KEY_ACCESS_TOKEN) ?: return null
        val refresh = defaults.stringForKey(KEY_REFRESH_TOKEN) ?: return null
        return AuthToken(access, refresh)
    }

    override fun clearTokens() {
        defaults.removeObjectForKey(KEY_ACCESS_TOKEN)
        defaults.removeObjectForKey(KEY_REFRESH_TOKEN)
    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }
}
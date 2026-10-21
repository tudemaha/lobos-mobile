package id.my.tudemaha.lobos.platform

import android.content.Context
import android.content.SharedPreferences
import id.my.tudemaha.lobos.domain.model.AuthToken
import androidx.core.content.edit

class AndroidTokenStore(context: Context): TokenStore {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("lobos_auth_prefs", Context.MODE_PRIVATE)

    override fun saveTokens(tokens: AuthToken) {
        prefs.edit {
            putString(KEY_ACCESS_TOKEN, tokens.accessToken)
                .putString(KEY_REFRESH_TOKEN, tokens.refreshToken)
        }
    }

    override fun getTokens(): AuthToken? {
        val access = prefs.getString(KEY_ACCESS_TOKEN, null) ?: return null
        val refresh = prefs.getString(KEY_REFRESH_TOKEN, null) ?: return null
        return AuthToken(accessToken = access, refreshToken = refresh)
    }

    override fun clearTokens() {
        prefs.edit { clear() }
    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }
}
package id.my.tudemaha.lobos

import android.app.Application
import id.my.tudemaha.lobos.di.initKoin
import org.koin.android.ext.koin.androidContext

class LobosApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin { androidContext(this@LobosApplication) }
    }
}
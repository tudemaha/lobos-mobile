package id.my.tudemaha.lobos.di

import id.my.tudemaha.lobos.platform.AndroidTokenStore
import id.my.tudemaha.lobos.platform.TokenStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<TokenStore> { AndroidTokenStore(androidContext()) }
}
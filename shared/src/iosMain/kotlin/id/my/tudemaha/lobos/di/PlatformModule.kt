package id.my.tudemaha.lobos.di

import id.my.tudemaha.lobos.platform.IosTokenStore
import id.my.tudemaha.lobos.platform.TokenStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<TokenStore> { IosTokenStore() }
}
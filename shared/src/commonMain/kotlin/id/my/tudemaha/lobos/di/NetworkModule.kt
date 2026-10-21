package id.my.tudemaha.lobos.di

import id.my.tudemaha.lobos.data.remote.LobosAuthApi
import id.my.tudemaha.lobos.data.remote.LobosHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { LobosHttpClient.createHttpClient() }
    single { LobosAuthApi(get()) }
}
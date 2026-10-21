package id.my.tudemaha.lobos.di

import id.my.tudemaha.lobos.data.repository.AuthRepositoryImpl
import id.my.tudemaha.lobos.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}
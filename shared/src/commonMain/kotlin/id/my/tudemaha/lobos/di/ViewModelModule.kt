package id.my.tudemaha.lobos.di

import id.my.tudemaha.lobos.presentation.auth.LoginViewModel
import id.my.tudemaha.lobos.presentation.auth.RegisterViewModel
import id.my.tudemaha.lobos.presentation.auth.ResendVerificationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::ResendVerificationViewModel)
}
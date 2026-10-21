package id.my.tudemaha.lobos

import androidx.compose.ui.window.ComposeUIViewController
import id.my.tudemaha.lobos.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
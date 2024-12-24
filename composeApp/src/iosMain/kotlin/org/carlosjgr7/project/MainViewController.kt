package org.carlosjgr7.project

import androidx.compose.ui.window.ComposeUIViewController
import org.carlosjgr7.project.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {initKoin()}) { App() }
package org.carlosjgr7.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.carlosjgr7.project.ui.core.navigations.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}
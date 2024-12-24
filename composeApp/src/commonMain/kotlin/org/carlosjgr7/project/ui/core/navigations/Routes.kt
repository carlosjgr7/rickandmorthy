package org.carlosjgr7.project.ui.core.navigations

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Episodes : Routes("episodes")
    data object Characters : Routes("characters")

}


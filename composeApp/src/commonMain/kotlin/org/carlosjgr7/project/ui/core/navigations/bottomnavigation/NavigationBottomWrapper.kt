package org.carlosjgr7.project.ui.core.navigations.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.carlosjgr7.project.ui.core.navigations.Routes
import org.carlosjgr7.project.ui.home.characters.CharactersScreen
import org.carlosjgr7.project.ui.home.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route) {
            CharactersScreen()

        }
    }

}
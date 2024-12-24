package org.carlosjgr7.project.ui.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.carlosjgr7.project.ui.home.HomeScreen

@Composable
fun NavigationWrapper(){
    val mainNavController = rememberNavController()
    val startDestination = Routes.Home.route

    NavHost(navController = mainNavController, startDestination = startDestination){

        composable(route = Routes.Home.route){
            HomeScreen()
        }

    }

}
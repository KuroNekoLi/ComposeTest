package com.example.composetest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController,modifier:Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.A.title) {
        composable(BottomNavItem.A.title) { AScreen() }
        composable(BottomNavItem.B.title) { BScreen() }
        composable(BottomNavItem.C.title) { CScreen(navController) }
        composable("D") { DScreen() }
        composable("E") { EScreen() }
    }
}

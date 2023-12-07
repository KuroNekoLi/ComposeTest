package com.example.composetest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//@Composable
//fun NavigationGraph(navController: NavHostController,modifier:Modifier = Modifier) {
//    NavHost(navController, startDestination = BottomNavItem.A.title) {
//        composable(BottomNavItem.A.title) { AScreen() }
//        composable(BottomNavItem.B.title) { BScreen() }
//        composable(BottomNavItem.C.title) { CScreen(navController) }
//        composable("D") { DScreen() }
//        composable("E") { EScreen() }
//    }
//}
@Composable
fun MainNavigationGraph(mainNavController: NavHostController,secondNavHostController: NavHostController ,onClicked:()->Unit) {
    NavHost(navController = mainNavController, startDestination = BottomNavItem.A.title) {
        composable(BottomNavItem.A.title) { AScreen() }
        composable(BottomNavItem.B.title) { BScreen() }
        composable(BottomNavItem.C.title) {
            CScreen( onClicked = onClicked)
        }
    }
    NavHost(navController = secondNavHostController, startDestination = "D") {
        composable("D") { DScreen() }
        composable("E") { EScreen() }
    }
}

@Composable
fun SecondaryNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "D") {
        composable("D") { DScreen() }
        composable("E") { EScreen() }
    }
}
package com.example.composetest

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val mainNavController = rememberNavController()
    val secondaryNavController = rememberNavController()
    val isMainNavigation = remember { mutableStateOf(true) }

//    LaunchedEffect(key1 = mainNavController) {
//        mainNavController.currentBackStackEntryFlow.collect { backStackEntry ->
//            isMainNavigation.value = backStackEntry.destination.route !in listOf("D", "E")
//        }
//    }
//
//    if (isMainNavigation.value) {
//        MainScaffold(mainNavController,secondaryNavController)
//    } else {
//        SecondaryScaffold(secondaryNavController)
//    }
    MainScaffold(mainNavController,secondaryNavController)

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(BottomNavItem.A, BottomNavItem.B, BottomNavItem.C)
    NavigationBar { // 使用 NavigationBar 而不是 BottomNavigation
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.title,
                onClick = {
                    navController.navigate(item.title) {
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(mainNavController: NavHostController ,secondaryNavController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Main Screen") }) },
        bottomBar = { BottomNavigationBar(mainNavController) }
    ) {
        MainNavigationGraph(mainNavController, secondaryNavController,onClicked = {secondaryNavController.navigate("D")
        })
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryScaffold(secondaryNavController: NavHostController) {
    Scaffold(
        topBar = { /* 为DE屏幕定义不同的TopBar或者不定义 */ }
    ) {
        SecondaryNavigationGraph(secondaryNavController)
    }
}

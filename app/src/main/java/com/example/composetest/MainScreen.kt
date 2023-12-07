package com.example.composetest

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != "D" && currentRoute != "E") {
                TopAppBar(title = { Text("Main Screen") })
            }
        },
        bottomBar = {
            if (currentRoute != "D" && currentRoute != "E") {
                BottomNavigationBar(navController)
            }
        }
    ) {
        NavigationGraph(navController = navController, modifier = Modifier.padding(it))
    }
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
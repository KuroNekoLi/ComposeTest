package com.example.composetest

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItem(val title: String, val icon: ImageVector) {
    A("A", Icons.Default.Home),
    B("B", Icons.Default.Favorite),
    C("C", Icons.Default.Person)
}
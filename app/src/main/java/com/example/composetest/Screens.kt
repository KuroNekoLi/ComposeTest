package com.example.composetest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun AScreen() {
    Text("A Screen")
}

@Composable
fun BScreen() {
    Text("B Screen")
}

@Composable
fun CScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("D") }) {
            Text("Go to D Screen")
        }
        Button(onClick = { navController.navigate("E") }) {
            Text("Go to E Screen")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("D Screen") }) }
    ) { innerPadding ->
        Text(text= "D", modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("E Screen") }) }
    ) { innerPadding ->
        Text(text= "E", modifier = Modifier.padding(innerPadding))
    }
}
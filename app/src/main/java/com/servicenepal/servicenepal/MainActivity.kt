package com.servicenepal.servicenepal

import AddCardsView
import BottomNavigationBar
import CardsView
import HomeView
import ServiceView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.servicenepal.servicenepal.core.components.AppBar
import com.servicenepal.servicenepal.core.theme.ServiceNepalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServiceNepalTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppBar() },
        bottomBar = {
            BottomNavigationBar(
                selectedTabIndex = selectedTabIndex,
            ) { index ->
                selectedTabIndex = index
                // Handle tab selection
                when (index) {
                    0 -> navController.navigate("home") // Navigate to Home
                    1 -> navController.navigate("service") // Navigate to Service
                    2 -> navController.navigate("cards") // Navigate to Cards
                }
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.primary
        ) {
            NavHost(navController, startDestination = "home") {
                composable("home") { HomeView() }
                composable("service") { ServiceView() }
                composable("cards") { CardsView(navController) }
                composable("addCards") { AddCardsView(navController) }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    ServiceNepalTheme {
        MainScreen()
    }
}
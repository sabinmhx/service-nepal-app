package com.servicenepal.servicenepal

import AddCardsView
import BottomNavigationBar
import CardsView
import HomeView
import LoginView
import RegisterView
import ServiceView
import SplashScreen
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.servicenepal.servicenepal.core.components.AppBar
import com.servicenepal.servicenepal.core.theme.ServiceNepalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ServiceNepalTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    var showSplash by remember { mutableStateOf(true) }
    if (showSplash) {
        SplashScreen(onTimeout = { showSplash = false })
    } else {
        AuthenticationScreen(navController)
    }
}

@Composable
fun AuthenticationScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginView(navController) }
        composable("register") { RegisterView(navController) }
        composable("main") { MainScreen(navController) }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    
    Scaffold(
        topBar = { AppBar() },
        bottomBar = {
            BottomNavigationBar(
                selectedTabIndex = selectedTabIndex
            ) { index ->
                selectedTabIndex = index
                when (index) {
                    0 -> navController.navigate("home") { launchSingleTop = true }
                    1 -> navController.navigate("service") { launchSingleTop = true }
                    2 -> navController.navigate("cards") { launchSingleTop = true }
                }
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController = navController, startDestination = "home") {
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
        val navController = rememberNavController()
        MainScreen(navController)
    }
}

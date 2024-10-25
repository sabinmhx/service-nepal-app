package com.servicenepal.servicenepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.servicenepal.servicenepal.ui.theme.ServiceNepalTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.filled.Home
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    // State to hold the selected tab index
    private var selectedTabIndex by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServiceNepalTheme {
                Scaffold(
                    topBar = { AppBar() },  // Your app bar
                    bottomBar = {
                        BottomNavigationBar(selectedTabIndex) { newIndex ->
                            selectedTabIndex = newIndex
                        }
                    }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        // Show content based on the selected tab index
                        when (selectedTabIndex) {
                            0 -> HomeView()     // Home content
                            1 -> ServiceView()  // Services content
                            2 -> CardsView()    // Cards content
                            3 -> SettingsView()  // Settings content
                        }
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center // Center the title
            ) {
                Text("Service Nepal")
            }
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors() // You can customize colors if needed
    )
}



@Composable
fun ScrollableBanner() {
    // Dummy banner images for the scrollable banner
    val bannerImages = listOf(
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain"
    )

    val pagerState = rememberPagerState(pageCount = { bannerImages.size })

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        // HorizontalPager for full-width banners
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Set a fixed height for the banner
            ) {
                Image(
                    painter = rememberAsyncImagePainter(bannerImages[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Stretch and crop the image
                    modifier = Modifier.fillMaxSize() // Fill the entire Box
                )
            }
        }

        // Dots Indicator
        DotsIndicator(pagerState.currentPage, bannerImages.size)
    }
}

@Composable
fun DotsIndicator(currentIndex: Int, totalDots: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        for (i in 0 until totalDots) {
            val dotColor = if (i == currentIndex) {
                MaterialTheme.colorScheme.primary
            } else {
                Color.LightGray
            }
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .padding(2.dp)
                    .background(dotColor, shape = CircleShape)
            )
        }
    }
}




@Composable
fun ServiceGrid() {
    val textState = remember { mutableStateOf("Services") }
    val services = listOf(
        ServiceItem("Service 1", "https://via.placeholder.com/100"),
        ServiceItem("Service 2", "https://via.placeholder.com/100"),
        ServiceItem("Service 3", "https://via.placeholder.com/100"),
        ServiceItem("Service 4", "https://via.placeholder.com/100"),
        ServiceItem("Service 5", "https://via.placeholder.com/100"),
        ServiceItem("Service 6", "https://via.placeholder.com/100"),
        ServiceItem("Service 1", "https://via.placeholder.com/100"),
        ServiceItem("Service 2", "https://via.placeholder.com/100"),
        ServiceItem("Service 3", "https://via.placeholder.com/100"),
        ServiceItem("Service 4", "https://via.placeholder.com/100"),
        ServiceItem("Service 5", "https://via.placeholder.com/100"),
        ServiceItem("Service 1", "https://via.placeholder.com/100"),
        ServiceItem("Service 2", "https://via.placeholder.com/100"),
        ServiceItem("Service 3", "https://via.placeholder.com/100"),
        ServiceItem("Service 4", "https://via.placeholder.com/100"),
        ServiceItem("Service 5", "https://via.placeholder.com/100"),
    )
    Text(text = textState.value, style = MaterialTheme.typography.titleLarge)
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Set number of columns in the grid
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(services.size) { index ->
            ServiceCard(service = services[index])
        }
    }
}

@Composable
fun ServiceCard(service: ServiceItem) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { /* Handle service item click */ },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(service.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp) // Size of the service image
        )
        Text(
            text = service.name,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

data class ServiceItem(val name: String, val imageUrl: String)




@Composable
fun BottomNavigationBar(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    BottomNavigation {
        // Home Navigation Item
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) }
        )

        // Services Navigation Item
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Business, contentDescription = "Services") },
            label = { Text("Services") },
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) }
        )

        // Cards Navigation Item
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.CreditCard, contentDescription = "Cards") },
            label = { Text("Cards") },
            selected = selectedTabIndex == 2,
            onClick = { onTabSelected(2) }
        )

        // Settings Navigation Item
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = selectedTabIndex == 3,
            onClick = { onTabSelected(3) }
        )
    }
}


@Composable
fun HomeView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ScrollableBanner()
        ServiceGrid()
    }
}

@Composable
fun ServiceView() {
    // Content for Services
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Services Screen", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun CardsView() {
    // Content for Cards
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cards Screen", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun SettingsView() {
    // Content for Settings
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Settings Screen", style = MaterialTheme.typography.headlineLarge)
    }
}
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MiscellaneousServices
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.servicenepal.servicenepal.ui.home.model.FeaturedItem

@Composable
fun HomeView() {
    val favorites = listOf(
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain"
    )
    val favoritesPagerState = rememberPagerState(pageCount = { favorites.size })

    val featured = listOf(
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "Image 1 Description"
        ),
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "Image 2 Description"
        ),
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "Image 3 Description"
        )
    )
    // Use a verticalScroll to make the whole page scrollable
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Favourites",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )

        Favorites(favorites, favoritesPagerState)

        DotsIndicator(currentIndex = favoritesPagerState.currentPage, totalDots = favorites.size)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(MaterialTheme.colorScheme.secondary)
                .padding(top = 16.dp)
        ) {
            Column {
                Text(
                    text = "Featured",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Start)
                )
                Featured(featured)

                Text(
                    text = "Services",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Start)
                )

                // LazyColumn for services is no longer needed, replaced with Column
                for (service in serviceList) {
                    ServiceItem(service.iconResId, service.title)
                }
            }
        }


    }
}


@Composable
fun ServiceItem(iconResId: Int, title: String) {
    // Container for each service item
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp), // Add padding for spacing
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp), // Add elevation for shadow
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set background color to white
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Padding inside the card
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Load icon
//            Image(
//                painter = rememberAsyncImagePainter(iconResId),
//                contentDescription = null,
//                modifier = Modifier.size(40.dp) // Set icon size
//            )
            Icon(
                imageVector = Icons.Filled.MiscellaneousServices,
                contentDescription = "Add Card",
                modifier = Modifier.size(40.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

// Sample data class for services
data class Service(val iconResId: Int, val title: String)

// Sample data for services list
val serviceList = listOf(
    Service(iconResId = 1, title = "Service 1"),
    Service(iconResId = 2, title = "Service 2"),
    Service(iconResId = 3, title = "Service 3")
)

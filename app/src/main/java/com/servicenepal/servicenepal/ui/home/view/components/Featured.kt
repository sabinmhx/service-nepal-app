import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.SubdirectoryArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.servicenepal.servicenepal.ui.home.model.FeaturedItem

@Composable
fun Featured(bannerItems: List<FeaturedItem>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(bannerItems) { item ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
                ) {
                    Column {
                        // Image Section
                        Image(
                            painter = rememberAsyncImagePainter(item.imageUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )

                        // Text and Button Section
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = item.caption,
                                color = Color.Black
                            )
                            IconButton(
                                onClick = { /* Handle click here */ },
                                modifier = Modifier.size(40.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowForward,
                                    contentDescription = "Arrow Forward"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

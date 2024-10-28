import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun Favorites(bannerImages:List<String>, pagerState: PagerState) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            Box(
                Modifier.padding(horizontal = 10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .width(500.dp)
                        .height(200.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp) // Set elevation
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(bannerImages[page]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
    }
}

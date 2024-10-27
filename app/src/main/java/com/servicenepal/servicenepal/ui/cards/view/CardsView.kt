import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


data class CardItem(val imageUrl: String)

@Composable
fun CardsView() {
    // Example list of card items with just image URLs
    val cardItems = remember {
        listOf(
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg"),
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg"),
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cardItems) { item ->
                CardItemView(item)
            }

            item {
                AddCardButton()
            }
        }
    }
}

@Composable
fun CardItemView(cardItem: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        // Just fill the card with the image
        Image(
            painter = rememberAsyncImagePainter(cardItem.imageUrl),
            contentDescription = null, // No need for content description for purely decorative images
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Crop the image to fill the card
        )
    }
}

@Composable
fun AddCardButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust height as needed
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .background(Color.White, shape = RoundedCornerShape(8.dp)) // Added shape for background
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Card",
                modifier = Modifier.size(40.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Add Card", color = Color.Gray)
        }
    }
}


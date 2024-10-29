import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(currentIndex: Int, totalDots: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        repeat(totalDots) { i ->
            val dotColor = if (i == currentIndex) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSecondary
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .padding(2.dp)
                    .background(dotColor, shape = CircleShape)
            )
        }
    }
}
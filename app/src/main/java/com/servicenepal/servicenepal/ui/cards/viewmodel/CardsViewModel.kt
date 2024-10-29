import androidx.lifecycle.ViewModel
import com.servicenepal.servicenepal.ui.cards.model.CardItem

class CardsViewModel : ViewModel() {
    val cardItems = listOf(
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg"),
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg"),
            CardItem("https://cdn.mycreativeshop.com/images/templates/62635/assisted-living-business-card-2ukob2cdda-template-62635-flat1-thumb.jpg")
        )
    // You can add more methods to fetch or manipulate services as needed
}

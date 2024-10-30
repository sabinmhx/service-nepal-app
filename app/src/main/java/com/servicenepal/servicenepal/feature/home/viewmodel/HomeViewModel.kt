import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.servicenepal.servicenepal.feature.home.model.FavoriteItem
import com.servicenepal.servicenepal.feature.home.model.FeaturedItem
import com.servicenepal.servicenepal.feature.home.model.ServiceItem
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val favoriteItemList = listOf(
        FavoriteItem(
            "https://thumbs.dreamstime.com/b/uk-driving-licence-illustration-isolated-white-background-person-driver-license-338230617.jpg",
            "First Image Description"
        ),
        FavoriteItem(
            "https://thumbs.dreamstime.com/b/uk-driving-licence-illustration-isolated-white-background-person-driver-license-338230617.jpg",
            "First Image Description"
        ),
        FavoriteItem(
            "https://thumbs.dreamstime.com/b/uk-driving-licence-illustration-isolated-white-background-person-driver-license-338230617.jpg",
            "First Image Description"
        ),
    )

    val featuredItemList = listOf(
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "First Image Description"
        ),
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "Second Image Description"
        ),
        FeaturedItem(
            "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
            "Third Image Description"
        )
    )

    val serviceItemList = listOf(
        ServiceItem(iconResId = 1, title = "Driving License"),
        ServiceItem(iconResId = 2, title = "Citizenship"),
        ServiceItem(iconResId = 3, title = "National ID")
    )


    fun fetchData() {
        viewModelScope.launch {
        }
    }
}

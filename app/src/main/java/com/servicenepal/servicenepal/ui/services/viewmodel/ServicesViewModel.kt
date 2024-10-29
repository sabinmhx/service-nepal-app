import androidx.lifecycle.ViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

class ServiceViewModel : ViewModel() {
    // Define the list of services
    val services = listOf(
        ServiceItems("Service 1", Icons.Filled.Build),
        ServiceItems("Service 2", Icons.Filled.Security),
        ServiceItems("Service 3", Icons.Filled.Favorite),
        ServiceItems("Service 4", Icons.Filled.ShoppingCart)
    )

    // You can add more methods to fetch or manipulate services as needed
}

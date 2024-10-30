import androidx.lifecycle.ViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

class ServiceViewModel : ViewModel() {
    val serviceList = listOf(
        ServicesItems("Driving License", Icons.Filled.Build),
        ServicesItems("National ID", Icons.Filled.Security),
        ServicesItems("Citizenship", Icons.Filled.Favorite),
        ServicesItems("Health Insurance", Icons.Filled.ShoppingCart)
    )
}

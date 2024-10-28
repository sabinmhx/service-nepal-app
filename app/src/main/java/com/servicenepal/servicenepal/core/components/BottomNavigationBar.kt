import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    BottomNavigation(
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Business, contentDescription = "Services") },
            label = { Text("Services") },
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.CreditCard, contentDescription = "Cards") },
            label = { Text("Cards") },
            selected = selectedTabIndex == 2,
            onClick = { onTabSelected(2) }
        )
    }
}

package com.servicenepal.servicenepal.ui.home.viewmodel

import androidx.compose.foundation.pager.rememberPagerState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.servicenepal.servicenepal.ui.home.model.FeaturedItem

class HomeViewModel : ViewModel() {
    // LiveData or StateFlow for favorites and featured items
    val favorites = listOf(
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain",
        "https://th.bing.com/th/id/OIP.DugIIyks79SZ1i1ognqDZQHaEc?rs=1&pid=ImgDetMain"
    )

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

    // Function to fetch or manipulate data if needed
    fun fetchData() {
        viewModelScope.launch {
            // Fetch data logic here
        }
    }
}

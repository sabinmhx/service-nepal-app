package com.servicenepal.servicenepal.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text("Service Nepal") },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.PersonOutline, contentDescription = "Profile")
            }
        }
    )
}

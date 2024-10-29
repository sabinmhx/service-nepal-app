package com.servicenepal.servicenepal.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Define Dark Color Scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1A73E8),       // Deep Blue
    secondary = Color(0xFFBB86FC),      // Light Gray (Soft accent)
    background = Color(0xFF121212),     // Dark Gray for dark theme background
    onPrimary = Color.White,            // White text/icons on primary
    onSecondary = Color.Black           // Black text/icons on secondary
)

// Define Light Color Scheme
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3A7CA5),        // Classic Blue
    secondary = Color(0xFFF5F5F5),      // Off-White for secondary accent
    background = Color.White,           // White background for light theme
    onPrimary = Color.White,            // White text/icons on primary
    onSecondary = Color(0xFF1A1A1A),
    onBackground = Color.White,
)

@Composable
fun ServiceNepalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Determine color scheme based on dark mode and dynamic color settings
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Apply Material theme with selected color scheme and typography
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,  // Ensure you have Typography defined elsewhere in your theme package
        content = content
    )
}

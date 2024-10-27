package com.servicenepal.servicenepal.ui.cards.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun AddCardsView(navController: NavController) {
    var cardName by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher for image picker
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? -> imageUri = uri }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Card Name TextField
        OutlinedTextField(
            value = cardName,
            onValueChange = { cardName = it },
            label = { Text("Card Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to pick image
        Button(
            onClick = { imagePickerLauncher.launch("image/*") }
        ) {
            Text("Upload Card Image")
        }

        // Display selected image if available
        imageUri?.let { uri ->
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = "Card Image",
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save button to submit the card details
        Button(
            onClick = {
                // Handle save action here
                navController.popBackStack() // Navigate back after saving
            }
        ) {
            Text("Save Card")
        }
    }
}

package com.example.smartprofilemanagement.ui.screens.profileactivationnotification

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileActivationScreen() {
    var profileName by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = profileName,
            onValueChange = { profileName = it },
            label = { Text("Enter profile name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    if (profileName.isNotBlank()) {
                        // Perform activation logic, e.g., generate notification
                        activateProfile(profileName, context)
                        profileName = ""
                        keyboardController?.hide()
                    }
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp),
            leadingIcon = {
                IconButton(
                    onClick = {
                        // Handle attachments or additional options
                    }
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Activate Profile")
                }
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (profileName.isNotBlank()) {
                    activateProfile(profileName, context)
                    profileName = ""
                    keyboardController?.hide()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Activate Profile")
        }
    }
}

private fun activateProfile(profileName: String, context: Context) {
    // Implement your activation logic here, e.g., generate a notification
    // You can use the 'profileName' to identify and activate the corresponding profile
    // For simplicity, let's just print a log message
    Log.d("ProfileActivation", "Activated profile: $profileName")
}

@Composable
@Preview(showBackground = true)
fun ProfileActivationScreenPreview() {
    SmartProfileManagementTheme {
        ProfileActivationScreen()
    }
}

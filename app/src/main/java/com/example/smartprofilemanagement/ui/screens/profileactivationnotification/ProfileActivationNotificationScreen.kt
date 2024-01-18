package com.example.smartprofilemanagement.ui.screens.profileactivationnotification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.R
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileActivationScreen(navController: NavController) {
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

    // Example: Generate a notification
    showNotification(context, profileName)
}

private fun showNotification(context: Context, profileName: String) {
    val notificationManager = NotificationManagerCompat.from(context)

    // Create a notification channel for Android Oreo and higher
    createNotificationChannel(context)

    val notificationId = 1 // Unique ID for the notification
    val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle("Profile Activated")
        .setContentText("Profile: $profileName has been activated.")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setCategory(NotificationCompat.CATEGORY_MESSAGE)

    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return
    }
    notificationManager.notify(notificationId, notificationBuilder.build())
}

// Notification Channel
private const val CHANNEL_ID = "ProfileActivationChannel"
private const val CHANNEL_NAME = "Profile Activation Channel"
private const val CHANNEL_DESCRIPTION = "Channel for profile activation notifications"

@RequiresApi(Build.VERSION_CODES.O)
private fun createNotificationChannel(context: Context) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
        description = CHANNEL_DESCRIPTION
    }

    notificationManager.createNotificationChannel(channel)
}


//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun ProfileActivationScreen(navController: NavController) {
//    var profileName by remember { mutableStateOf("") }
//    val keyboardController = LocalSoftwareKeyboardController.current
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        OutlinedTextField(
//            value = profileName,
//            onValueChange = { profileName = it },
//            label = { Text("Enter profile name") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Send
//            ),
//            keyboardActions = KeyboardActions(
//                onSend = {
//                    if (profileName.isNotBlank()) {
//                        // Perform activation logic, e.g., generate notification
//                        activateProfile(profileName, context)
//                        profileName = ""
//                        keyboardController?.hide()
//                    }
//                }
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(MaterialTheme.colorScheme.background)
//                .padding(8.dp),
//            leadingIcon = {
//                IconButton(
//                    onClick = {
//                        // Handle attachments or additional options
//                    }
//                ) {
//                    Icon(imageVector = Icons.Default.Send, contentDescription = "Activate Profile")
//                }
//            },
//            singleLine = true
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                if (profileName.isNotBlank()) {
//                    activateProfile(profileName, context)
//                    profileName = ""
//                    keyboardController?.hide()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 8.dp)
//        ) {
//            Text("Activate Profile")
//        }
//    }
//}
//
//private fun activateProfile(profileName: String, context: Context) {
//    // Implement your activation logic here, e.g., generate a notification
//    // You can use the 'profileName' to identify and activate the corresponding profile
//    // For simplicity, let's just print a log message
//    Log.d("ProfileActivation", "Activated profile: $profileName")
//    showNotification(context, profileName)
//}

@Composable
@Preview(showBackground = true)
fun ProfileActivationScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        ProfileActivationScreen(navController = navController)
    }
}

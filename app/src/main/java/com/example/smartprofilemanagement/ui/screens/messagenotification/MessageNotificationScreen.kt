package com.example.smartprofilemanagement.ui.screens.messagenotification


import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.R
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.screens.sleepinghours.SleepingHourViewModel
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MessageNotificationScreen(navController: NavController,
                              viewModel: MessageNotificationViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    var message by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Enter message") },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                // Limit the phone number to 10 digits
                if (it.length <= 11) {
                    phoneNumber = it
                }
            },
            label = { Text("Enter phone number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Perform your logic when Done is clicked
                    keyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    // Perform activation logic, e.g., send message
                    sendMessage(message, phoneNumber, context)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send Message")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Send Message")
                }
            }

            Button(
                onClick = {
                    // Perform deactivation logic, if needed
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Message")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Add Message")
                }
            }
        }
    }
}

private fun sendMessage(message: String, phoneNumber: String, context: Context) {
    if (message.isNotBlank() && phoneNumber.isNotBlank()) {
        // Implement your message sending logic here
        // For now, let's just display a toast message
        showToast(context, "Message sent to $phoneNumber: $message")
    } else {
        showToast(context, "Please enter both message and phone number")
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}








@Preview(showBackground = true)
@Composable
fun MessageNotifictionPreview(){
    SmartProfileManagementTheme {


        val navController = rememberNavController()
        MessageNotificationScreen(navController = navController)
    }
}
package com.example.smartprofilemanagement.ui.screens.messagenotification


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

private val Typography.h5: TextStyle
    get() {
        TODO("Not yet implemented")
    }

@Composable
fun MessageNotificationScreen(
    navController: NavController,
    profileId: Long?,
    viewModel: MessageNotificationViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var activationMessage by remember { mutableStateOf(TextFieldValue()) }
    var deactivationMessage by remember { mutableStateOf(TextFieldValue()) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Message Notification Settings", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(16.dp))

        // Activation Message
        MessageTextField(
            value = activationMessage,
            onValueChange = { activationMessage = it },
            label = "Activation Message"
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Deactivation Message
        MessageTextField(
            value = deactivationMessage,
            onValueChange = { deactivationMessage = it },
            label = "Deactivation Message"
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Phone Number
        MessageTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = "Phone Number"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Save Button
        Button(onClick = {
            val message = Message(
                profileId = profileId,
                activationMessage = activationMessage.text,
                deactivationMessage = deactivationMessage.text,
                phoneNumber = phoneNumber.text
            )

          // viewModel.insertMessage(message)
            navController.navigateUp()
        }) {
            Text("Save Message")
        }
    }
}

@Composable
fun MessageTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) }
    )
}










//@Composable
//fun MessageNotificationScreen(navController: NavController) {
//    var messages by remember { mutableStateOf(emptyList<Profile>()) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        AddMessageSection(
//            onAddMessage = {
//                messages = messages + it
//            }
//        )
//
//        MessageList(messages = messages)
//    }
//}
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun AddMessageSection(onAddMessage: (Profile) -> Unit) {
//    var newMessage by remember { mutableStateOf("") }
//    val isSending by remember { mutableStateOf(false) }
//    val keyboardController = LocalSoftwareKeyboardController.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//
//        OutlinedTextField(
//            value = newMessage,
//            onValueChange = { newMessage = it },
//            label = { Text("Enter your message") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Send
//            ),
//            keyboardActions = KeyboardActions(
//                onSend = {
//                    if (newMessage.isNotBlank() && !isSending) {
//                        onAddMessage(createDefaultProfile(newMessage))
//                        newMessage = ""
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
//                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
//                }
//            },
//            singleLine = true
//        )
//
//        Button(
//            onClick = {
//                if (newMessage.isNotBlank() && !isSending) {
//                    onAddMessage(createDefaultProfile(newMessage))
//                    newMessage = ""
//                    keyboardController?.hide()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 8.dp)
//        ) {
//            Text("Send")
//        }
//    }
//}
//
//@Composable
//fun MessageList(messages: List<Profile>) {
//    LazyColumn {
//        items(messages) { message ->
//            MessageItem(message = message)
//        }
//    }
//}
//
//@Composable
//fun MessageItem(message: Profile) {
//    message.message?.let {
//        Text(
//        text = it,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(MaterialTheme.colorScheme.primary)
//            .padding(8.dp),
//        color = Color.White
//    )
//    }
//}
//
//private fun createDefaultProfile(message: String): Profile {
//    return Profile(
//        id = 1,
//        name = "John",
//        profileName = "John's Profile",
//        blackList = "Some blacklisted items",
//        latitude = 123.456,
//        longitude = 789.012,
//        activationradius = 10.0f,
//        wifiStatus = true,
//        sleepingHoursStart = 10,
//        sleepingHoursEnd = 18,
//        message = message,
//        location = "Some location",
//        phoneNumber = "123-456-7890",
//        description = "Default Description",
//        reminder = "Default Reminder",
//        isDone = false,
//        isDeleted = false,
//        title = "Default Title",
//        timestamp = System.currentTimeMillis(),
//        isActive = true
//    )
//}
//


@Preview(showBackground = true)
@Composable
fun MessageNotifictionPreview(){
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        MessageNotificationScreen(navController = navController, profileId = null)
    }
}
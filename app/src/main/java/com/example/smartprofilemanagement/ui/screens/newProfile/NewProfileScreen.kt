package com.example.smartprofilemanagement.ui.screens.newProfile


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme


@Composable
fun NewProfileScreen(
   // profileViewModel: ProfileViewModel = viewModel(),
    navController: NavController) {

    val profileName by remember { mutableStateOf(TextFieldValue()) }
    val location by remember { mutableStateOf(TextFieldValue()) }
    var wifiStatus by remember { mutableStateOf(false) }
    val blackList by remember { mutableStateOf(TextFieldValue()) }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = profileName.text,
                onValueChange = { profileName.text },
                label = { Text("Enter Profile Name") }
            )
            TextField(
                value = location.text,
                onValueChange = { location.text },
                label = { Text("Enter Location") }
            )
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("WiFi Status:")
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = wifiStatus,
                    onCheckedChange = { wifiStatus = it }
                )
            }
            TextField(
                value = blackList.text,
                onValueChange = { blackList.text},
                label = { Text("Enter Blacklisted Numbers (comma-separated)") }
            )
            Button(
                onClick = {
                    Profile(
                        id = 1,
                        name = "John",
                        profileName = "John's Profile",
                        blackList = "Some blacklisted items",
                        latitude = 123.456,
                        longitude = 789.012,
                        activationradius = 10.0f,
                        wifiStatus = true,
                        sleepingHoursStart = 10,
                        sleepingHoursEnd = 18,
                        message = "Hello, World!",
                        location = "Some location",
                        phoneNumber = "123-456-7890",
                        description = "Default Description",
                        reminder = "Default Reminder",
                        isDone = false,
                        isDeleted = false,
                        title = "Default Title",
                        timestamp =  System.currentTimeMillis(),
                        isActive = true
                    )

                },
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text("Save Profile")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun NewProfileScreenPreview() {
    SmartProfileManagementTheme {
        val navController= rememberNavController()
        NewProfileScreen(navController = navController)
    }

}

package com.example.smartprofilemanagement.ui.screens.addreminders


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.navigation.Screen
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme


@Composable
fun AddReminderScreen(
    navController: NavController) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize() // Fills the parent
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centering content horizontally
            verticalArrangement = Arrangement.spacedBy(20.dp) // Space between children
        ) {
            Button(onClick = { }) {
                Text("Add Reminder Screen")
            }

            FilledTonalButton(onClick = { navController.navigate(Screen.Home.route) }) {
                Text("Home")
            }
        }
    }
//    var title by remember { mutableStateOf("") }
//    var description by remember { mutableStateOf("") }
//    var isLocationBased by remember { mutableStateOf(false) }
//    var latitude by remember { mutableDoubleStateOf(0.0) }
//    var longitude by remember { mutableDoubleStateOf(0.0) }
//    var timestamp by remember { mutableLongStateOf(0L) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        // UI for entering title
//        OutlinedTextField(
//            value = title,
//            onValueChange = { title = it },
//            label = { Text("Title") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp),
//        )
//
//        OutlinedTextField(
//            value = description,
//            onValueChange = { description = it },
//            label = { Text("Description") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp),
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text("Time-based Reminder")
//            Switch(
//                checked = isLocationBased,
//                onCheckedChange = { isLocationBased = it },
//                modifier = Modifier.padding(start = 8.dp)
//            )
//            Text(text = "Location-based Reminder")
//        }
//
//        if (isLocationBased) {
//            OutlinedTextField(
//                value = latitude.toString(),
//                onValueChange = { latitude = it.toDoubleOrNull() ?: 0.0 },
//                label = { Text("Latitude") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//            )
//
//            OutlinedTextField(
//                value = longitude.toString(),
//                onValueChange = { longitude = it.toDoubleOrNull() ?: 0.0 },
//                label = { Text("Longitude") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//            )
//        }
//
//        if (!isLocationBased) {
//            OutlinedTextField(
//                value = timestamp.toString(),
//                onValueChange = { timestamp = it.toLongOrNull() ?: 0L },
//                label = { Text("Timestamp") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//            )
//        }
//
//        Button(
//            onClick = {
//
//                val reminder = Reminder(
//                    title = title,
//                    description = description,
//                    isLocationBased = isLocationBased,
//                    latitude = if (isLocationBased) latitude else null,
//                    longitude = if (isLocationBased) longitude else null,
//                    timestamp = if (!isLocationBased) timestamp else null
//                )
//          //      viewModel.insert(reminder)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp)
//        ) {
//            Text(text = "Save Reminder")
//        }
//    }
}


//fun Reminder(
//    title: String,
//    description: String,
//    isLocationBased: Boolean,
//    latitude: Double?,
//    longitude: Double?,
//    timestamp: Long?
//): Screen.Profile {
//    TODO("Not yet implemented")
//}

@Preview(showBackground = true)
@Composable
fun AddReminderScreenPreview(){
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        AddReminderScreen(navController = navController)
    }
}
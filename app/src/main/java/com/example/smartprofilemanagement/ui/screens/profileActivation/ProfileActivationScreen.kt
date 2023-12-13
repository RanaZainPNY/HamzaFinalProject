package com.example.smartprofilemanagement.ui.screens.profileActivation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.ui.screens.sleepinghours.body1
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


private val Typography.h4: TextStyle
    get() {
        TODO("Not yet implemented")
    }

@Composable
fun ProfileActivationScreen(
    // viewModel: ProfileViewModel = viewModel(),
    navController: NavController)
{
    var latitude by remember { mutableDoubleStateOf(0.0) }
    var longitude by remember { mutableDoubleStateOf(0.0) }

    // Mockup for location updates
    // In a real app, you would get this from a location service
    LaunchedEffect(Unit) {
        // Simulate location updates every two minutes
        val locationUpdateJob = launch {
            while (isActive) {
                delay(2 * 60 * 1000) // simulate 2 minutes delay
                // Replace the following with actual logic to get location updates
                latitude = getRandomLatitude()
                longitude = getRandomLongitude()
            }
        }

        onDispose {
            locationUpdateJob.cancel()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("WELCOME TO SPM", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(24.dp))

        Text("Latitude: $latitude", style = MaterialTheme.typography.body1)
        Text("Longitude: $longitude", style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val profile = Profile(
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
               // viewModel.insert(profile)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "Save Profile Activation")
        }
    }
}

private fun CoroutineScope.onDispose(function: () -> Unit) {
    TODO("Not yet implemented")
}

// Mock function to generate random latitude
fun getRandomLatitude(): Double {
    return (-90..90).shuffled().first().toDouble()
}

// Mock function to generate random longitude
fun getRandomLongitude(): Double {
    return (-180..180).shuffled().first().toDouble()
}
@Preview(showBackground = true)
@Composable
fun ProfileActivationPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        ProfileActivationScreen(navController = navController)
    }

}

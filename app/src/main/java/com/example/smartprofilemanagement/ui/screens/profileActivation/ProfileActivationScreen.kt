package com.example.smartprofilemanagement.ui.screens.profileActivation

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.addMarker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun ProfileActivationScreen(
    navController: NavController,
    //viewModel: ProfileActivationViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var mapView by remember { mutableStateOf<MapView?>(null) }
    var googleMap by remember { mutableStateOf<GoogleMap?>(null) }

    val context = LocalContext.current

    DisposableEffect(context) {
        mapView = MapView(context)
        mapView?.onCreate(Bundle())

        onDispose {
            mapView?.onDestroy()
        }
    }

    LaunchedEffect(mapView) {
        mapView?.getMapAsync { map ->
            googleMap = map
            googleMap?.uiSettings?.isMyLocationButtonEnabled = false

            // Simulating location update every two minutes
            var latitude = 37.7749
            var longitude = -122.4194

            // Coroutine to update location every two minutes
            while (true) {
                launch {
                    delay(120000L) // 2 minutes delay


                    // Update latitude and longitude (Replace with actual logic to get new coordinates)
                    latitude += 0.001
                    longitude += 0.001

                    // Clear previous markers
                    googleMap?.clear()

                    // Add a marker at the updated location
                    val currentLocation = LatLng(latitude, longitude)
                    googleMap?.addMarker {
                        position(currentLocation)
                        title("Current Location")
                    }

                    // Move camera to the updated location
                    googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray) // Set background color
    ) {
        // MapView container
        AndroidView(
            factory = { mapView!! },
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            // MapView will be added here
        }

        // Add any additional UI components or information as needed below the map
        Text(
            text = "Profile Activation Screen",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}


//@Composable
//fun ProfileActivationScreen(
//    // viewModel: ProfileViewModel = viewModel(),
//    navController: NavController)
//{
//    var latitude by remember { mutableDoubleStateOf(0.0) }
//    var longitude by remember { mutableDoubleStateOf(0.0) }
//
//    // In a real app, you would get this from a location service
//    LaunchedEffect(Unit) {
//        // Simulate location updates every two minutes
//        val locationUpdateJob = launch {
//            while (isActive) {
//                delay(2 * 60 * 1000) // simulate 2 minutes delay
//                // Replace the following with actual logic to get location updates
//                latitude = getRandomLatitude()
//                longitude = getRandomLongitude()
//            }
//        }
//        onDispose {
//            locationUpdateJob.cancel()
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("WELCOME TO SPM", style = MaterialTheme.typography.h4)
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Text("Latitude: $latitude", style = MaterialTheme.typography.body1)
//        Text("Longitude: $longitude", style = MaterialTheme.typography.body1)
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(
//            onClick = {
//                val profile = Profile(
//                    id = 1,
//                    name = "John",
//                    profileName = "John's Profile",
//                    blackList = "Some blacklisted items",
//                    latitude = 123.456,
//                    longitude = 789.012,
//                    activationradius = 10.0f,
//                    wifiStatus = true,
//                    sleepingHoursStart = 10,
//                    sleepingHoursEnd = 18,
//                    message = "Hello, World!",
//                    location = "Some location",
//                    phoneNumber = "123-456-7890",
//                    description = "Default Description",
//                    reminder = "Default Reminder",
//                    isDone = false,
//                    isDeleted = false,
//                    title = "Default Title",
//                    timestamp =  System.currentTimeMillis(),
//                    isActive = true
//                )
//               // viewModel.insert(profile)
//            },
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(8.dp)
//        ) {
//            Text(text = "Save Profile Activation")
//        }
//    }
//}
//
//private fun CoroutineScope.onDispose(function: () -> Unit) {
//    TODO("Not yet implemented")
//}
//
//// Mock function to generate random latitude
//fun getRandomLatitude(): Double {
//    return (-90..90).shuffled().first().toDouble()
//}
//
//// Mock function to generate random longitude
//fun getRandomLongitude(): Double {
//    return (-180..180).shuffled().first().toDouble()
//}
@Preview(showBackground = true)
@Composable
fun ProfileActivationPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        ProfileActivationScreen(navController = navController)
    }

}

package com.example.smartprofilemanagement.ui.screens.currentlocation

import android.Manifest
import android.annotation.SuppressLint
import androidx.annotation.RequiresPermission
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


@SuppressLint("MissingPermission")
@Composable
fun CurrentLocationScreen(
//    locationViewModel: LocationViewModel = viewModel(),
    navController: NavController) {
    val permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
    )
    PermissionBox(
        permissions = permissions,
        requiredPermissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    ) {
        CurrentLocationContent()
    }


    @RequiresPermission(
        anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION],
    )
    @Composable
    fun CurrentLocationContent(usePreciseLocation: Boolean) {
        val scope = rememberCoroutineScope()
        val context = LocalContext.current
        val locationClient = remember {
            LocationServices.getFusedLocationProviderClient(context)
        }
        var locationInfo by remember {
            mutableStateOf("")
        }

        Column(
            Modifier
                .fillMaxWidth()
                .animateContentSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    scope.launch(Dispatchers.IO) {
                        val result = locationClient.lastLocation.await()
                        locationInfo = if (result == null) {
                            "No last known location. Try fetching the current location first"
                        } else {
                            "Current location is \n" + "lat : ${result.latitude}\n" +
                                    "long : ${result.longitude}\n" + "fetched at ${System.currentTimeMillis()}"
                        }
                    }
                },
            ) {
                Text("Get last known location")
            }

            Button(
                onClick = {
                    scope.launch(Dispatchers.IO) {
                        val priority = if (usePreciseLocation) {
                            Priority.PRIORITY_HIGH_ACCURACY
                        } else {
                            Priority.PRIORITY_BALANCED_POWER_ACCURACY
                        }
                        val result = locationClient.getCurrentLocation(
                            priority,
                            CancellationTokenSource().token,
                        ).await()
                        result?.let { fetchedLocation ->
                            locationInfo =
                                "Current location is \n" + "lat : ${fetchedLocation.latitude}\n" +
                                        "long : ${fetchedLocation.longitude}\n" + "fetched at ${System.currentTimeMillis()}"
                        }
                    }
                },
            ) {
                Text(text = "Get current location")
            }
            Text(
                text = locationInfo,
            )
        }
    }
}

fun CurrentLocationContent() {
    TODO("Not yet implemented")
}

@Composable
fun PermissionBox(permissions: List<String>, requiredPermissions: List<String>, content: Any) {
    TODO("Not yet implemented")
}
@Preview(showBackground = true)
@Composable
fun CurrentLocationPreview(){
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        CurrentLocationScreen(navController = navController)
        }
}
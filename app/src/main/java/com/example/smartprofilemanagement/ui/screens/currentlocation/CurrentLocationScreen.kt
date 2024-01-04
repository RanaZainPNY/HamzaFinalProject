package com.example.smartprofilemanagement.ui.screens.currentlocation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresPermission
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
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
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.navigation.Screen
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

val Pakistanstate = LatLng(30.00000000, 70.00000000)
val defaultCameraPosition = CameraPosition.fromLatLngZoom(Pakistanstate, 10f)

@Composable
fun CurrentLocationScreen(
    viewModel: CurrentLocationViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavController,

) {
    val cameraPositionState = rememberCameraPositionState(

    )
    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMapsView(
            modifier = Modifier.fillMaxHeight(350F),
            cameraPositionState = cameraPositionState
        ) {

        }
    }
}

@Composable
fun GoogleMapsView(
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState,
    onMapLoaded: () -> Unit
) {
    val locationState = rememberMarkerState(
        position = Pakistanstate
    )

    val mapUiSettings = remember {
        MapUiSettings(compassEnabled = false)
    }

    val mapProperties = remember {
        MapProperties(mapType = MapType.NORMAL)
    }

    GoogleMap(
        modifier = modifier,
        onMapLoaded = onMapLoaded,
        uiSettings = mapUiSettings,
        properties = mapProperties,
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = locationState,
            draggable = true,
            title = "Lahore",
            snippet = "Pakistan",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        )
    }
}

@Preview(showBackground = true)
    @Composable
    fun CurrentLocationPreview() {
        SmartProfileManagementTheme {
            val navController = rememberNavController()
            val cameraPositionState = rememberCameraPositionState()
            CurrentLocationScreen(navController = navController)
        }
    }

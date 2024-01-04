package com.example.smartprofilemanagement

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.navigation.NavigationHost
import com.google.maps.android.compose.CameraPositionState

//import com.perspectivev.workouttracker.ui.navigation.NavigationHost
//import com.perspectivev.workouttracker.ui.navigation.BottomNavItem
//import com.perspectivev.workouttracker.ui.navigation.BottomNavigationBar
//import com.perspectivev.workouttracker.ui.navigation.Screen

/**
 * Top level composable that represents screens for the application.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun AppInit(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
//        bottomBar = {
//            BottomNavigationBar(items = listOf(
//                BottomNavItem(
//                    Screen.Home.name,
//                    Screen.Home.route,
//                    Icons.Filled.Home,
//                    Icons.Outlined.Home
//                ),
//                BottomNavItem(
//                    Screen.Progress.name,
//                    Screen.Progress.route,
//                    Icons.Filled.AccountCircle,
//                    Icons.Outlined.AccountCircle
//                ),
//                BottomNavItem(
//                    Screen.Setting.name,
//                    Screen.Setting.route,
//                    Icons.Filled.Settings,
//                    Icons.Outlined.Settings
//                ),
//            ),
//                navController = navController,
//                onItemClick = {
//                    navController.navigate(it.route)
//                })
//        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            NavigationHost(navController = navController, cameraPositionState = CameraPositionState())
        }
    }
}


/**
 * App bar to display title and conditionally display the back navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back"//stringResource(string.back_button)
                    )
                }
            }
        }
    )
}

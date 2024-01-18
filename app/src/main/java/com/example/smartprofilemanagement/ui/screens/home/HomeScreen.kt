package com.example.smartprofilemanagement.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.navigation.Screen
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import kotlinx.coroutines.launch

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector?,
    val unselectedIcon: ImageVector?,
    val badgeCount: Int? = null,
    val route: String,
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    val items = listOf(
//        NavigationItem(
//            title = "New Profile",
//            selectedIcon = Icons.Filled.Person, // Change the icons accordingly
//            unselectedIcon = Icons.Outlined.Person,
//            route = "newProfile"
//        ),
        NavigationItem(
            title = "Manage Reminders",
           selectedIcon = null,
            unselectedIcon = null,
            route = Screen.ManageReminders.route
        ),
        NavigationItem(
            title = "Manage Profiles",
           selectedIcon = null,
           unselectedIcon = null,
            route = Screen.Profile.route
        ),
        NavigationItem(
            title = "Message Notification",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.MessageNotification.route
        ),

        NavigationItem(
            title = "Current Location",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.CurrentLocation.route
        ),
        NavigationItem(
            title = "Profile Activation",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.ProfileActivation.route
        ),
        NavigationItem(
            title = "Call Blocking",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.CallBlocking.route
        ),
        NavigationItem(
            title = "Call Log",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.MaintainCallLogs.route
        ),
        NavigationItem(
            title = "Sleeping Hours",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.Sleepinghours.route
        ),
        NavigationItem(
            title = "MaintainCallLog",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.MaintainCallLogs.route
        ),
        NavigationItem(
            title = "Add Reminder",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.AddReminder.route
        ),
        NavigationItem(
            title = "Profile Activation Notifications",
            selectedIcon = null,
            unselectedIcon = null,
            route = Screen.ProfileActivationNotification.route
        ),

    )
    Spacer(modifier = Modifier.fillMaxWidth(1f))

    // Logout button
    Button(
        onClick = {
            // Handle logout
            // For example, navigate to the login screen
            navController.navigate(Screen.Signup.route)
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Logout")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                                navController?.navigate(item.route)

                            },
                            icon = {
                                (if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon)?.let {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = item.title
                                    )
                                }
                            },
                            badge = {
                                item.badgeCount?.let {
                                    Text(text = item.badgeCount.toString())
                                }
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Smart Profile Manager")
                        },

                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )

                            }
                        }
                    )
                }
            ) {contentPadding ->
//
//                        Text(
//                            text = "Body Content",
//                            modifier = Modifier
//                                .padding(contentPadding)
//                                .fillMaxSize()
//                                .wrapContentSize()
//                        )

                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding)
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){

//                    Button( modifier = Modifier
//                        .padding(contentPadding),
////                        .fillMaxSize()
////                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("SignUp")
//                        }) {
//                        Text(text="Go to Signup Screen")
//                    }

//                    Button( modifier = Modifier
//                        .padding(contentPadding),
////                        .fillMaxSize()
////                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("profileActivation")
//                        }) {
//                        Text(text="Go to profileActivation Screen")
//                    }

//                    Button( modifier = Modifier
//                        .padding(contentPadding),
////                        .fillMaxSize()
////                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("manageProfiles")
//                        }) {
//                        Text(text="Go to manageProfiles Screen")
//                    }


//                    Button( modifier = Modifier
//                        .padding(contentPadding),
////                        .fillMaxSize()
////                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("newProfile")
//                        }) {
//                        Text(text="Go to newProfile Screen")
//                    }



//                    Button( modifier = Modifier
//                        .padding(contentPadding),
////                        .fillMaxSize()
////                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("addReminder")
//                        }) {
//                        Text(text="Go to addReminder Screen")
//                    }



//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("manageReminders")
//                        }) {
//                        Text(text="Go to manageReminders Screen")
//                    }
//
//
//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("messageNotification")
//                        }) {
//                        Text(text="Go to messageNotification Screen")
//                    }
//
//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("currentLocation")
//                        }) {
//                        Text(text="Go to currentLocation Screen")
//                    }
//
//
//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("callLog")
//                        }) {
//                        Text(text="Go to callLog Screen")
//                    }
//
//
//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("callBlocking")
//                        }) {
//                        Text(text="Go to callBlocking Screen")
//                    }
//
//
//
//                    Button( modifier = Modifier
//                        .padding(contentPadding)
//                        .fillMaxSize()
//                        .wrapContentSize(),
//                        onClick = {
//                            navController.navigate("sleepingHours")
//                        }) {
//                        Text(text="Go to sleepingHours Screen")
//                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}
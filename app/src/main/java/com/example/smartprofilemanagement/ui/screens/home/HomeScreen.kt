package com.example.smartprofilemanagement.ui.screens.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.navigation.Screen
import com.example.smartprofilemanagement.ui.screens.profile.ProfileViewModel
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.Surface as Surface

//import com.google.android.libraries.mapsplatform.transportation.consumer.model.Route

//import com.perspectivev.workouttracker.ui.theme.WorkoutTrackerTheme

/**
 * Entry route for Home screen
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//fun HomeScreen(
//    modifier: Modifier = Modifier,
//    viewModel: ProfileViewModel = viewModel(factory = AppViewModelProvider.Factory)
//) {
////    val homeUiState by viewModel.homeUiState.collectAsState()
////    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//
//
//}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel:HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val profileList by viewModel.items.collectAsState(emptyList())

    var model by remember {
        val td = Profile(
            id = 0,
            name = "",
            profileName = "",
            blackList = "",
            latitude = 123.456,
            longitude = 789.012,
            activationradius = 0.0f,
            wifiStatus = true,
            sleepingHoursStart = 0,
            sleepingHoursEnd = 0,
            message = "Hello, World!",
            location = "",
            phoneNumber = "123-456-7890",
            description = "Default Description",
            reminder = "",
            isDone = false,
            isDeleted = false,
            title = "",
            timestamp =  System.currentTimeMillis(),
            isActive = false
        )
        mutableStateOf(td)
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showBottomSheet = true
                    model = Profile(
                        id = 0,
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
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        },
        floatingActionButtonPosition = FabPosition.End,

    ) {

        ProfileList(
            profiles = profileList,
            onEdit = {
                model = it
                showBottomSheet = true
            },
            onDelete = {
                viewModel.delete(it);
            }
        )

        if(showBottomSheet){
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                modifier = Modifier
                    .padding(15.dp)
                    .height(220.dp)
            ) {
                Column(
                    Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                ){
                    var name by rememberSaveable { mutableStateOf(if(model.id==0) "" else model.name) }
                    var nameHasError by remember { mutableStateOf(false) }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = name,
                            onValueChange = {
                                name = it
//                                nameHasError = (name == null || name.trim() == "")
                                nameHasError = false
                            },
                            label = { Text("Name") },
                            isError = nameHasError
                        )
                    }

                    Button(
                        onClick = {
                            nameHasError = (name == null || name.trim() == "")
                            if (!nameHasError) {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                                if (model.id == 0) {
                                    viewModel.insert(Profile(
                                        id = 0,
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
                                    ))
                                }else {
//                                    model.name = name
//                                    viewModel.update(model,exerciseList);
//                                    model = Exercise(0, "")
                                }
                            } else {
                                Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT)
                                    .show();
                            }
                        },
                        modifier = Modifier
                            .padding(0.dp, 10.dp)
                            .align(Alignment.End)
                    ) {
                        Text("Save")
                    }
                }

            }
        }


    }



//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(
//            onClick = {
//                navController.navigate(Screen.Signup.route)
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Go To  SignUp")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                navController.navigate(Screen.Profile.route)
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("View Profile")
//        }
//    }
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@ExperimentalMaterial3Api
fun ProfileList(
    profiles: List<Profile>,
    onEdit: (profile: Profile) -> Unit,
    onDelete: (profile: Profile) -> Unit
) {
    Column {
        Row(modifier = Modifier.padding(15.dp,15.dp)) {
            Text(
                text = "Profile List",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Divider()
        LazyColumn(content = {
            itemsIndexed(items = profiles, key = { _, it -> it.id }) { index, it ->
                ListItem(
                    modifier = Modifier.clickable { onEdit(it) },
                    headlineContent = { Text(it.name) },
                    trailingContent = {
                        IconButton(onClick = { onDelete(it) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = "delete",
                                tint = Color(0xFFEA7171)
                            )
                        }
                    }
                )
            }
        })
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    SmartProfileManagementTheme {
//        val navController = rememberNavController()
//        HomeScreen(navController= navController) }
//}


@Composable
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "Full", showSystemUi = true)
@ExperimentalMaterial3Api
fun HomeScreenPreview() {
    SmartProfileManagementTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileList(
                listOf(
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
                        isActive = true),
                    Profile(
                        id = 2,
                        name = "Hamza",
                        profileName = "hamza's Profile",
                        blackList = "Some blacklisted items",
                        latitude = 121.456,
                        longitude = 179.012,
                        activationradius = 10.0f,
                        wifiStatus = true,
                        sleepingHoursStart = 10,
                        sleepingHoursEnd = 18,
                        message = "hamza, World!",
                        location = "Some Hamza",
                        phoneNumber = "123-456-7890",
                        description = "Default Description",
                        reminder = "Default Reminder",
                        isDone = false,
                        isDeleted = false,
                        title = "Default Title",
                        timestamp =  System.currentTimeMillis(),
                        isActive = true
                    ),
                ),
                onEdit = {},
                onDelete = {}
            )
        }
    }
}


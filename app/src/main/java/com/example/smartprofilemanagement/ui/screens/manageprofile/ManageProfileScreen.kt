package com.example.smartprofilemanagement.ui.screens.manageprofile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.screens.sleepinghours.body1
import com.example.smartprofilemanagement.ui.screens.sleepinghours.h6
//import com.example.smartprofilemanageent.ui.theme.SMARTprofileManageentTheme
//import com.example.smartprofilemanageent.viewmodel.ProfileViewModel
import kotlin.reflect.KProperty


private fun LazyListScope.items(count: Any, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}

private operator fun Unit.getValue(nothing: Nothing?, property: KProperty<*>): Any {
    return TODO("Provide the return value")
}
@Composable
fun ManageProfilesScreen(
//    viewModel: ProfileViewModel = viewModel(),
    navController: NavController
) {
//    val profiles by viewModel.allProfiles.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Manage Profiles", style = MaterialTheme.typography.h6)

        LazyColumn {
//            items(profiles) { profile ->
//                ProfileItem(profile = profile) {
//                    // Use coroutine scope to call suspend function
//                    viewModel.deleteProfile(profiles)
//                }
        }
    }

    Button(
        onClick = {
            // Navigate to the screen where the user can add a new profile
            navController.navigate("newProfile")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Add New Profile")
    }
}


@Composable
fun ProfileItem(profile: Int, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation =  6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Profile Name:", style = MaterialTheme.typography.h6)
            Text(text = "Description:", style = MaterialTheme.typography.body1)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                // Button to delete the profile
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Profile")
                }
            }
        }
    }
}


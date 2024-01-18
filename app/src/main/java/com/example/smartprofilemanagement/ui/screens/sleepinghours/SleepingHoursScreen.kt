package com.example.smartprofilemanagement.ui.screens.sleepinghours


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun SleepingHoursScreen(
   // viewModel: SleepingHourViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavController) {
  // val sleepingHours by sleepingHours.observeAsState(emptyList())
    var selectedStartTime by remember { mutableStateOf<String?>(null) }
    var selectedEndTime by remember { mutableStateOf<String?>(null) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Sleeping Hours", style = typography.bodyMedium)

        LazyColumn {
          //  items(sleepingHours) { hours ->
               // SleepingHoursItem(profile = hours)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TimePicker(title = "Start Time", initialTime = selectedStartTime, onTimeSelected = { selectedStartTime = it })

            TimePicker(
                title = "End Time",
                initialTime = selectedEndTime,
                onTimeSelected = { selectedEndTime = it }
            )
        }


        Button(
            onClick = {
                // Clear sleeping hours
              //  viewModel.clearSleepingHours()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Clear Sleeping Hours")
        }
    }


private fun LazyItemScope.sleepingHoursItem(profile: Int) {
    TODO("Not yet implemented")
}

@Composable
fun SleepingHoursItem(profile: Profile) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Start Time: ${
                profile.sleepingHoursStart?.let {
                    Date(
                        it
                    )
                }?.let { SimpleDateFormat("HH:mm", Locale.getDefault()).format(it) }
            }", style = typography.bodyMedium)
            Text(text = "End Time: ${
                profile.sleepingHoursEnd?.let {

                    Date(
                        it
                    )
                }?.let { SimpleDateFormat("HH:mm", Locale.getDefault()).format(it) }
            }", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
@Composable
fun TimePicker(
    title: String,
    initialTime: String?,
    onTimeSelected: (String) -> Unit
) {
    var time by remember { mutableStateOf(initialTime ?: "00:00") }

    Column {
        Text(text = title, style = MaterialTheme.typography.bodyMedium)

        BasicTextField(
            value = time,
            onValueChange = {
                time = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.NumberPassword
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Button(
            onClick = { onTimeSelected(time) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Set $title")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SleepingHoursPreview(){
    SmartProfileManagementTheme {
        val navController = rememberNavController()

        SleepingHoursScreen(navController= navController)
    }
}
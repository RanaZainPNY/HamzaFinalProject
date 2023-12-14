import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel

import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

@Composable
fun ManageRemindersScreen(
    navController: NavController,
//    viewModel: ReminderViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val context = LocalContext.current
    var reminders by remember { mutableStateOf(dummyReminders) }

    LazyColumn {
        items(reminders) { reminder ->
            ReminderItem(
                reminder = reminder,
                onEditClick = { editedReminder ->
                    // Implement logic to edit the reminder
                    // For simplicity, let's just print a log message
                    println("Edit clicked: $editedReminder")
                },
                onDeleteClick = { deletedReminder ->
                    // Implement logic to delete the reminder
                    // For simplicity, let's just print a log message
                    println("Delete clicked: $deletedReminder")
                    reminders = reminders.filterNot { it == deletedReminder }
                }
            )
        }
    }
}

@Composable
fun ReminderItem(
    reminder: Reminder,
    onEditClick: (Reminder) -> Unit,
    onDeleteClick: (Reminder) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Reminder: ${reminder.title}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${reminder.description}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Time: ${reminder.time}")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                IconButton(
                    onClick = { onEditClick(reminder) },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(
                    onClick = { onDeleteClick(reminder) },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManageRemindersScreenPreview() {
    SmartProfileManagementTheme {
        ManageRemindersScreen(navController = rememberNavController())
    }
}

// Dummy data for preview
val dummyReminders = List(4) { index ->
    Reminder(
        id = index,
        title = "Reminder $index",
        description = "Description for Reminder $index",
        time = "10:00 AM"
    )
}

// Data class for Reminder
//data class Reminder(
//    val id: Int,
//    val title: String,
//    val description: String,
//    val time: String
//)
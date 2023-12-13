package com.example.smartprofilemanagement.ui.screens.maintaincalllog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

@Composable
fun MaintainCallLogScreen(
    navController: NavController
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                // Implement logic to view the call log
                // For simplicity, let's just print a log message
                println("View Call Log clicked")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Call, contentDescription = "View Call Log")
            Spacer(modifier = Modifier.width(8.dp))
            Text("View Call Log")
        }

        Button(
            onClick = {
                // Implement logic to clear the call log
                // For simplicity, let's just print a log message
                println("Clear Call Log clicked")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear Call Log")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Clear Call Log")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MaintainCallLogScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        MaintainCallLogScreen(navController = navController)
    }
}
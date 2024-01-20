package com.example.smartprofilemanagement.ui.screens.maintaincalllog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.CallLog
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme


@Composable
fun MaintainCallLogScreen (
    navController: NavController,
    callLogs: List<CallLog> = emptyList() ,
    onClearClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Display the list of call logs using LazyColumn
        LazyColumn {
            items(callLogs) { callLog ->
                CallLogItem(callLog = callLog)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to clear the call log
        Button(
            onClick = onClearClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Clear Call Log")
        }
    }
}

@Composable
fun CallLogItem(callLog: CallLog) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Caller: ${callLog.callerName}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Duration: ${callLog.duration} mins")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Timestamp: ${callLog.timestamp}")
        }
    }
}

// Preview
@Composable
@Preview(showBackground = true)
fun MaintainCallLogScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        val callLogs = List(5) {
            CallLog(0, "John Doe", 5, "2023-12-01 10:30 AM")
        }
        MaintainCallLogScreen(
            navController = navController,
            callLogs = callLogs,
            onClearClick = {})
    }
}



//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Call
//import androidx.compose.material.icons.filled.Clear
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.core.app.ActivityCompat
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.smartprofilemanagement.Manifest
//import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
//
//
//@Composable
//fun MaintainCallLogScreen(
//    navController: NavController
//) {
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Button(
//            onClick = {
//                // Implement logic to view the call log
//                // For simplicity, let's just print a log message
//                println("View Call Log clicked")
//
//
//
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp)
//                .padding(bottom = 16.dp)
//        ) {
//            Icon(imageVector = Icons.Default.Call, contentDescription = "View Call Log")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("View Call Log")
//        }
//
//        Button(
//            onClick = {
//                // Implement logic to clear the call log
//                // For simplicity, let's just print a log message
//                println("Clear Call Log clicked")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp)
//        ) {
//            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear Call Log")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("Clear Call Log")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MaintainCallLogScreenPreview() {
//    SmartProfileManagementTheme {
//        val navController = rememberNavController()
//        MaintainCallLogScreen(navController = navController)
//    }
//}
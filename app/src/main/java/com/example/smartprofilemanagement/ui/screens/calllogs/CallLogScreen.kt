package com.example.smartprofilemanagement.ui.screens.calllogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme
import java.util.concurrent.TimeUnit


private val LazyListScope.profileList: Int
    get() {
        TODO("Not yet implemented")
    }
private val timestamp: String
    get() {
        TODO("Not yet implemented")
    }
private val phoneNumber: String
    get() {
        TODO("Not yet implemented")
    }

private fun LazyListScope.items(count: String, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}

@Composable
fun CallLogScreen(
    //viewModel: CallLogViewModel,
    navController: NavController) {
   // val callLogs by viewModel.allCallLogs.observeAsState(emptyList())
    val cutoffTime = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Call Log", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(profileList) { profile ->
                CallLogItem(callLog = profile)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
           //     viewModel.deleteOutdatedCallLogs(cutoffTime)
            }
        ) {
            Text("Clear Outdated Call Logs")
        }
    }
}

@Composable
fun CallLogItem(callLog: Int) {
    Text(
        text = "Number: ${phoneNumber}, Timestamp: $timestamp",
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun CallLogScreen(){
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        CallLogScreen()
    }
}
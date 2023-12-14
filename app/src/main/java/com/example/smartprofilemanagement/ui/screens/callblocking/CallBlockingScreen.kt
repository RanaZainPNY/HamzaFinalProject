package com.example.smartprofilemanagement.ui.screens.callblocking

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallBlockingScreen(
    navController: NavController)
{
    var phoneNumber by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Call Blocking") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Enter Phone Number to Block") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Button(
                    onClick = {
                    //    viewModel.blockCall(phoneNumber)
                        phoneNumber = ""
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Block Call")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Blocked Calls:")
         //       val blockedCalls by viewModel.blockedCalls.observeAsState(emptyList())
           ///     blockedCalls.forEach { blockedCall ->
              //      blockedCall.phoneNumber?.let { it1 -> Text(text = it1) }
                }
             })
        }

@Preview(showBackground = true)
@Composable
fun CallBlockingScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        CallBlockingScreen(navController = navController)
    }
}

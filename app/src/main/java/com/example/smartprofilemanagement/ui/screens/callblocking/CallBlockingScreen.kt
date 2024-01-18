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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.data.entities.CallBlock
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*

import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartprofilemanagement.R


import kotlinx.coroutines.launch

data class BlockedNumber(val id: Int, val number: String)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CallBlockingScreen(navController: NavController, viewModel: CallblockViewModel = viewModel(factory = AppViewModelProvider.Factory),
    onNavigateUp: () -> Unit
) {
    val viewModel: CallblockViewModel = viewModel(
        factory = AppViewModelProvider.Factory)
    var newNumber by remember { mutableStateOf("") }
    var blockedNumbers by remember { mutableStateOf<List<BlockedNumber>>(emptyList()) }
    var isBlockingEnabled by remember { mutableStateOf(true) }

    val keyboardController = LocalSoftwareKeyboardController.current

    val context = LocalContext.current

    // Function to add a number to the block list
    fun addToBlockList(number: String) {
        blockedNumbers = blockedNumbers + BlockedNumber(blockedNumbers.size, number)
        newNumber = ""
        keyboardController?.hide()
    }

    // Function to remove a number from the block list
    fun removeFromBlockList(id: Int) {
        blockedNumbers = blockedNumbers.filter { it.id != id }
    }

    // Function to handle blocking logic based on the number
    @Composable
    fun blockCall(number: String) {
        if (isBlockingEnabled && blockedNumbers.any { it.number == number }) {
            // Block the call
            // Implement your call blocking logic here
            // For now, we'll just display a toast message
            showToast(context, "Call from $number is blocked")
        } else {
            // Allow the call
            // Implement your call handling logic here
            // For now, we'll just display a toast message
            showToast(context, "Call from $number is allowed")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back),
                modifier = Modifier
                    .clickable { onNavigateUp() }
                    .padding(8.dp)
            )
            Text(
                text = stringResource(id = R.string.call_blocking_title),

            )
            Spacer(modifier = Modifier.padding(48.dp))
        }

        // Enable/Disable Blocking Switch
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = isBlockingEnabled,
                onCheckedChange = { isChecked ->
                    isBlockingEnabled = isChecked
                },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.enable_call_blocking),

            )
        }

        // Blocked Numbers List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(blockedNumbers) { blockedNumber ->
                BlockedNumberItem(
                    blockedNumber = blockedNumber,
                    onRemove = { removeFromBlockList(blockedNumber.id) }
                )
            }
        }

        // Add Number Section
        AddNumberSection(
            newNumber = newNumber,
            onNumberChange = { newNumber = it },
            onAddNumber = { addToBlockList(it) }
        )
    }
}

@Composable
fun BlockedNumberItem(
    blockedNumber: BlockedNumber,
    onRemove: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Phone,
            contentDescription = stringResource(id = R.string.phone_icon),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = blockedNumber.number)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onRemove,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.delete_icon)
            )
        }
    }
}

@Composable
fun AddNumberSection(
    newNumber: String,
    onNumberChange: (String) -> Unit,
    onAddNumber: (String) -> Unit
) {
    var isWarningVisible by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = newNumber,
            onValueChange = {
                onNumberChange(it)
                isWarningVisible = false
            },
            label = { Text(text = stringResource(id = R.string.enter_phone_number)) },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (newNumber.isNotBlank()) {
                        onAddNumber(newNumber)
                    } else {
                        isWarningVisible = true
                    }
                }
            ),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        IconButton(
            onClick = {
                if (newNumber.isNotBlank()) {
                    onAddNumber(newNumber)
                } else {
                    isWarningVisible = true
                }
            },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.add_icon)
            )
        }
    }

    if (isWarningVisible) {
        WarningMessage(text = stringResource(id = R.string.enter_valid_number_warning))
    }
}

@Composable
fun WarningMessage(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Warning,
            contentDescription = stringResource(id = R.string.warning_icon),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


@Preview(showBackground = true)
@Composable
fun CallBlockingScreenPreview() {
    SmartProfileManagementTheme {
        val navController = rememberNavController()
        CallBlockingScreen(navController = navController, onNavigateUp = {})
    }
}

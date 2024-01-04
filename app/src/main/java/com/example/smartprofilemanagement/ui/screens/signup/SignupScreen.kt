package com.example.smartprofilemanagement.ui.screens.signup


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartprofilemanagement.R
import com.example.smartprofilemanagement.data.entities.User
//import com.example.smartprofilemanagement.ui.theme.AlegreyaFontFamily
//import com.example.smartprofilemanagement.ui.theme.AlegreyaSansFontFamily
import com.example.smartprofilemanagement.data.viewmodels.AppViewModelProvider
import com.example.smartprofilemanagement.ui.navigation.Screen
import com.example.smartprofilemanagement.ui.theme.SmartProfileManagementTheme

//import com.example.smartprofilemanageent.ui.theme.SMARTprofileManageentTheme



@Composable
fun SignUpScreen(
    navController: NavController,
// viewModel: SignupViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {


    ////////////////////
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
//    val userList by viewModel.items.collectAsState(emptyList())
    var model by remember {
        var td = User(
            id = 0,
            username = "hamza",
            password = "pak123"
        )
        mutableStateOf(td)
    }

    var username by rememberSaveable { mutableStateOf(if (model.id == 0) "" else model.username) }
//    var password by rememberSaveable { mutableStateOf(if(model.id==0) "" else model.password) }
    var password by remember { mutableStateOf(TextFieldValue().text) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue().text) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Yellow
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.spm),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = TextFieldValue(it).text },
                placeholder = { Text(text = "Username") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = TextFieldValue(it).text },
                placeholder = { Text(text = "Password") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = TextFieldValue(it).text },
                placeholder = { Text(text = "Confirm Password") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // create a new user and add it to the database
//                    viewModel.insert(User(
//                        id=0,
//                        username = username.text,
//                        password = password.text
//                    ))
                    // navigate to the home screen
                    navController.navigate(Screen.Home.route)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(8.dp)
            ) {
                Text(text = "Sign Up")
            }

        }
    }
}




@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SmartProfileManagementTheme {
        SignUpScreen(navController = rememberNavController())
    }

}


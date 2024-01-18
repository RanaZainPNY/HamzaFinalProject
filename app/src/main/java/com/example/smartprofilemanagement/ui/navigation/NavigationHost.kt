package com.example.smartprofilemanagement.ui.navigation

import ManageRemindersScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartprofilemanagement.SplashScreen
import com.example.smartprofilemanagement.ui.screens.addreminders.AddReminderScreen
import com.example.smartprofilemanagement.ui.screens.callblocking.CallBlockingScreen
import com.example.smartprofilemanagement.ui.screens.calllogs.CallLogScreen
import com.example.smartprofilemanagement.ui.screens.currentlocation.CurrentLocationScreen
import com.example.smartprofilemanagement.ui.screens.home.HomeScreen
import com.example.smartprofilemanagement.ui.screens.maintaincalllog.MaintainCallLogScreen
import com.example.smartprofilemanagement.ui.screens.manageprofile.ManageProfilesScreen
//import com.example.smartprofilemanagement.ui.screens.managereminder.ManageRemindersScreen
import com.example.smartprofilemanagement.ui.screens.messagenotification.MessageNotificationScreen
import com.example.smartprofilemanagement.ui.screens.profile.ProfileScreen
import com.example.smartprofilemanagement.ui.screens.profileActivation.ProfileActivationScreen
import com.example.smartprofilemanagement.ui.screens.signup.SignUpScreen
import com.example.smartprofilemanagement.ui.screens.sleepinghours.SleepingHoursScreen
import com.google.maps.android.compose.CameraPositionState

//import com.perspectivev.workouttracker.ui.screens.exercise.ExerciseScreen
//import com.perspectivev.workouttracker.ui.screens.home.HomeScreen
//import com.perspectivev.workouttracker.ui.screens.progress.ProgressScreen
//import com.perspectivev.workouttracker.ui.screens.settings.SettingScreen
//import com.perspectivev.workouttracker.ui.screens.workout.WorkoutScreen


@Composable
fun NavigationHost (
    navController: NavHostController,
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier.padding(15.dp)
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route=Screen.Signup.route){
            SignUpScreen(navController = navController)
        }
        
        composable(route=Screen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(route=Screen.CallBlocking.route){
            CallBlockingScreen(navController = navController, onNavigateUp = {})
        }
        composable(route=Screen.CallLogs.route){
            CallLogScreen(navController = navController)
        }
      //  composable(route=Screen.MaintainCallLogs.route){
        //   MaintainCallLogScreen(navController = navController, callLogs = callLogs,
          //     onClearClick = {})
        //}

        composable(route=Screen.ProfileActivation.route){
            ProfileActivationScreen(navController = navController)
        }
        composable(route=Screen.ManageProfile.route){
            ManageProfilesScreen(navController = navController)
        }
        composable(route=Screen.ManageReminders.route){
            ManageRemindersScreen(navController = navController)
        }
        composable(route=Screen.AddReminder.route){
            AddReminderScreen(navController = navController)
        }
        composable(route=Screen.MessageNotification.route){
            MessageNotificationScreen(navController = navController)
        }
        composable(route=Screen.CurrentLocation.route){
            CurrentLocationScreen(navController = navController)
        }
        composable(route=Screen.Sleepinghours.route){
            SleepingHoursScreen(navController = navController)
        }


//        composable(route = Screen.Progress.route) {
//            ProgressScreen()
//        }
//        composable(route = Screen.Setting.route) {
//            SettingScreen(modifier,navController)
//        }
//        composable(route = Screen.Workout.route) {
//            WorkoutScreen()
//        }
//        composable(route = Screen.Exercise.route) {
//            ExerciseScreen()
//        }
////        composable(route = Screens.Workout.options.route) {
////            ItemEntryScreen(
////                navigateBack = { navController.popBackStack() },
////                onNavigateUp = { navController.navigateUp() }
////            )
////        }
    }

}
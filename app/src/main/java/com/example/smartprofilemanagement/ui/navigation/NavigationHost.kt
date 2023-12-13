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
import com.example.smartprofilemanagement.ui.screens.addreminders.AddReminderScreen
import com.example.smartprofilemanagement.ui.screens.callblocking.CallBlockingScreen
import com.example.smartprofilemanagement.ui.screens.calllogs.CallLogScreen
import com.example.smartprofilemanagement.ui.screens.currentlocation.CurrentLocationScreen
import com.example.smartprofilemanagement.ui.screens.home.HomeScreen
import com.example.smartprofilemanagement.ui.screens.maintaincalllog.MaintainCallLogScreen
import com.example.smartprofilemanagement.ui.screens.manageprofile.ManageProfilesScreen
//import com.example.smartprofilemanagement.ui.screens.managereminder.ManageRemindersScreen
import com.example.smartprofilemanagement.ui.screens.messagenotification.MessageNotificationScreen
import com.example.smartprofilemanagement.ui.screens.newProfile.NewProfileScreen
import com.example.smartprofilemanagement.ui.screens.profile.ProfileScreen
import com.example.smartprofilemanagement.ui.screens.profileActivation.ProfileActivationScreen
import com.example.smartprofilemanagement.ui.screens.signup.SignUpScreen

//import com.perspectivev.workouttracker.ui.screens.exercise.ExerciseScreen
//import com.perspectivev.workouttracker.ui.screens.home.HomeScreen
//import com.perspectivev.workouttracker.ui.screens.progress.ProgressScreen
//import com.perspectivev.workouttracker.ui.screens.settings.SettingScreen
//import com.perspectivev.workouttracker.ui.screens.workout.WorkoutScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationHost (
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route,
        modifier = Modifier.padding(15.dp)
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route=Screen.Signup.route){
            SignUpScreen(navController = navController)
        }
        
        composable(route=Screen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            CallBlockingScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            CallLogScreen()
        }
        composable(route=Screen.Profile.route){
            MaintainCallLogScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            NewProfileScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            ProfileActivationScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            ManageProfilesScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            ManageRemindersScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            AddReminderScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            MessageNotificationScreen(navController = navController)
        }
        composable(route=Screen.Profile.route){
            CurrentLocationScreen(navController = navController)
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
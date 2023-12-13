package com.example.smartprofilemanagement.ui.navigation


class ScreenOptions(val route:String,val name:String){
}
sealed class Screen(val options:ScreenOptions) {
    val route = options.route
    val name = options.name

    object Home:Screen(ScreenOptions("home_screen","Home"))

    object Profile:Screen(ScreenOptions("profile_screen","Profile"))

    object Signup: Screen(ScreenOptions("singup_screen", "SignUp"))

    object NewProfile: Screen(ScreenOptions("newprofile_screen", "NewProfile"))

    object ProfileActivation: Screen(ScreenOptions("profileactivation_screen", "ProfileActivation"))

    object CallBlocking: Screen(ScreenOptions("callblocking_screen", "Call Bocking"))

    object CallLogs: Screen(ScreenOptions("calllogs_screen", "Call Logs"))

    object AddReminder: Screen(ScreenOptions("addreminder_screen", "Add Reminder"))

    object CurrentLocation: Screen(ScreenOptions("currentlocation_screen", "Current Location"))

    object ManageProfile: Screen(ScreenOptions("manageprofile_screen", "Manage Profile"))

    object ManageReminders: Screen(ScreenOptions("managereminders_screen", "Manage Reminders"))

    object MessageNotification: Screen(ScreenOptions("messagenotification_screen", "Message Notification"))

    object Sleepinghours: Screen(ScreenOptions("sleepinghours_screen", "Sleeping Hours"))

    object ProfileActivationNotification: Screen(ScreenOptions("profileactivationnotification_screen", "Profile Activation Notification"))

//    object Progress:Screen(ScreenOptions("progress_screen","Progress"))
//    object Setting:Screen(ScreenOptions("setting_screen", "Settings"))
//
//
//
//    object Workout:Screen(ScreenOptions("workout_screen", "Workout")) {
//        object Save:Screen(ScreenOptions("workout_save","Save Workout"))
//    }
//    object Exercise:Screen(ScreenOptions("exercise_screen", "Exercise")){
//        object Save:Screen(ScreenOptions("exercise_save","Save Exercise"))
//    }
}

package com.example.smartprofilemanagement.data.viewmodels


import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.smartprofilemanagement.data.infrastructure.AppDatabase
import com.example.smartprofilemanagement.data.repositories.LocationRepository
import com.example.smartprofilemanagement.data.repositories.MessageRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import com.example.smartprofilemanagement.data.repositories.UserRepository
import com.example.smartprofilemanagement.ui.screens.currentlocation.CurrentLocationViewModel
import com.example.smartprofilemanagement.ui.screens.home.HomeViewModel
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel
import com.example.smartprofilemanagement.ui.screens.messagenotification.MessageNotificationViewModel
import com.example.smartprofilemanagement.ui.screens.profile.ProfileViewModel
import com.example.smartprofilemanagement.ui.screens.profileActivation.ProfileActivationViewModel
import com.example.smartprofilemanagement.ui.screens.signup.SignupViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        // Initializer for HomeViewModel
        initializer {
            ProfileViewModel(
                ProfileRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).profileDao()
                )
            )
        }

        initializer {
            HomeViewModel(
                ProfileRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).profileDao()
                )
            )
        }

//        initializer {
//            SignupViewModel(
//                UserRepository(
//                    AppDatabase.getDbInstance(getApplication().applicationContext).userDao()
//                )
//            )
//        }


        initializer {
            ReminderViewModel(
                ReminderRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).reminderDao()
                )
            )
//            HomeViewModel(getApplication().container.workoutRepository)
        }
        initializer {
            MessageNotificationViewModel(
                MessageRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).messageDao()
                )
            )
//            HomeViewModel(getApplication().container.workoutRepository)
        }
        initializer {
            CurrentLocationViewModel(
                LocationRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).locationDao()
                )
            )
        }
        initializer {
            ProfileActivationViewModel(
                ProfileActivationRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).profileActivationDao()
                )
            )
//            HomeViewModel(getApplication().container.workoutRepository)
        }

        // Initializer for HomeViewModel
//        initializer {
//            ExerciseViewModel(
//                ExerciseRepository(
//                    AppDatabase.getDbInstance(getApplication().applicationContext).exerciseDao()
//                )
//            )
//        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.getApplication(): Application = (this[APPLICATION_KEY]!!)

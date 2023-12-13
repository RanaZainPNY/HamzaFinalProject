package com.example.smartprofilemanagement.data.viewmodels


import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.smartprofilemanagement.data.infrastructure.AppDatabase
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import com.example.smartprofilemanagement.data.repositories.UserRepository
import com.example.smartprofilemanagement.ui.screens.home.HomeViewModel
import com.example.smartprofilemanagement.ui.screens.managereminder.ReminderViewModel
import com.example.smartprofilemanagement.ui.screens.profile.ProfileViewModel
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
//            HomeViewModel(getApplication().container.workoutRepository)
        }

        initializer {
            HomeViewModel(
                ProfileRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).profileDao()
                )
            )
//            HomeViewModel(getApplication().container.workoutRepository)
        }

        initializer {
            SignupViewModel(
                UserRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).userDao()
                )
            )
//            HomeViewModel(getApplication().container.workoutRepository)
        }


        initializer {
            ReminderViewModel(
                ReminderRepository(
                    AppDatabase.getDbInstance(getApplication().applicationContext).reminderDao()
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

package com.example.smartprofilemanagement.data.infrastructure

import android.content.Context
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import com.example.smartprofilemanagement.data.repositories.UserRepository


interface IAppContainer {
    val profileRepository: ProfileRepository
//    val userRepository: UserRepository
    val reminderRepository: ReminderRepository
//    val exerciseRepository: ExerciseRepository
}
class AppContainer(private val context: Context) : IAppContainer {
    override val profileRepository: ProfileRepository by lazy {
        ProfileRepository(AppDatabase.getDbInstance(context).profileDao())
    }

//    override val userRepository: UserRepository by lazy {
//        UserRepository(AppDatabase.getDbInstance(context).userDao())
//    }
//
//
    override val reminderRepository: ReminderRepository by lazy {
        ReminderRepository(AppDatabase.getDbInstance(context).reminderDao())
    }

//    override val exerciseRepository: ExerciseRepository by lazy {
//        ExerciseRepository(AppDatabase.getDbInstance(context).exerciseDao())
//    }

}

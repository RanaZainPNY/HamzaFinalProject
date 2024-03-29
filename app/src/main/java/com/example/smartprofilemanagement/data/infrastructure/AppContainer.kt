package com.example.smartprofilemanagement.data.infrastructure

import android.content.Context
import com.example.smartprofilemanagement.data.repositories.CallBlockRepository
import com.example.smartprofilemanagement.data.repositories.CallLogRepository
import com.example.smartprofilemanagement.data.repositories.LocationRepository
import com.example.smartprofilemanagement.data.repositories.MessageRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationNotificationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import com.example.smartprofilemanagement.data.repositories.SleepingHoursRepository
import com.example.smartprofilemanagement.data.repositories.UserRepository


interface IAppContainer {
    val profileRepository: ProfileRepository
//    val userRepository: UserRepository
    val reminderRepository: ReminderRepository
    val callLogRepository: CallLogRepository
    val callBlockRepository: CallBlockRepository
    val messageRepository: MessageRepository
    val locationRepository:LocationRepository
    val sleepingHoursRepository: SleepingHoursRepository
    val profileActivationRepository: ProfileActivationRepository
//    val exerciseRepository: ExerciseRepository
    val profileActivationNotificationRepository: ProfileActivationNotificationRepository
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

    override val callLogRepository: CallLogRepository by lazy {
        CallLogRepository(AppDatabase.getDbInstance(context).callLogDao())
    }
    override val callBlockRepository: CallBlockRepository by lazy {
        CallBlockRepository(AppDatabase.getDbInstance(context).callBlockDao())
    }
    override val messageRepository: MessageRepository by lazy {
        MessageRepository(AppDatabase.getDbInstance(context).messageDao())
    }
    override val locationRepository: LocationRepository by lazy {
        LocationRepository(AppDatabase.getDbInstance(context).locationDao())
    }
    override val sleepingHoursRepository: SleepingHoursRepository by lazy {
        SleepingHoursRepository(AppDatabase.getDbInstance(context).sleepingHoursDao())
    }
    override val profileActivationRepository: ProfileActivationRepository by lazy {
        ProfileActivationRepository(AppDatabase.getDbInstance(context).profileActivationDao())
    }
    override val profileActivationNotificationRepository: ProfileActivationNotificationRepository by lazy {
        ProfileActivationNotificationRepository(AppDatabase.getDbInstance(context).profileActivationNotificationDao())
    }

//    override val exerciseRepository: ExerciseRepository by lazy {
//        ExerciseRepository(AppDatabase.getDbInstance(context).exerciseDao())
//    }

}

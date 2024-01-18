package com.example.smartprofilemanagement.data.infrastructure

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartprofilemanagement.data.daos.CallBlockDao
import com.example.smartprofilemanagement.data.daos.CallLogDao
import com.example.smartprofilemanagement.data.daos.LocationDao
import com.example.smartprofilemanagement.data.daos.MessageDao
import com.example.smartprofilemanagement.data.daos.ProfileActivationDao
import com.example.smartprofilemanagement.data.daos.ProfileActivationNotificationDao
import com.example.smartprofilemanagement.data.daos.ProfileDao
import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.daos.SleepingHoursDao
import com.example.smartprofilemanagement.data.daos.UserDao
import com.example.smartprofilemanagement.data.entities.CallBlock
import com.example.smartprofilemanagement.data.entities.CallLog
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.entities.ProfileActivationNotification
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.entities.SleepingHours
import com.example.smartprofilemanagement.data.entities.User


@Database(
    entities = [
        Profile::class,
//        User::class,
        Reminder::class,
        CallLog::class,
        Message::class,
        CallBlock::class,
        SleepingHours::class,
        Location::class,
        ProfileActivation::class,
        ProfileActivationNotification::class,
//    Exercise::class,
               ],
    version = 12,
    exportSchema = true,
    autoMigrations = [
        AutoMigration (from = 4, to = 5),
        AutoMigration (from = 5, to = 6),
        AutoMigration (from = 6, to = 7),
        AutoMigration (from = 7, to = 8),
        AutoMigration (from = 8, to = 9),
        AutoMigration (from = 9, to = 10),
        AutoMigration (from = 10, to = 11),
        AutoMigration (from = 11, to = 12),

//        AutoMigration(from = 2, to = 3)

    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun callLogDao(): CallLogDao
    abstract fun callBlockDao(): CallBlockDao
//    abstract fun userDao(): UserDao
    abstract fun reminderDao(): ReminderDao
    abstract fun messageDao(): MessageDao
    abstract fun locationDao(): LocationDao
    abstract fun sleepingHoursDao(): SleepingHoursDao
    abstract fun profileActivationDao(): ProfileActivationDao
    abstract fun profileActivationNotificationDao(): ProfileActivationNotificationDao

//    val migration_4_5 = object : Migration(4,5){
//        override fun migrate(database: Support)
//    }
//    abstract fun exerciseDao(): ExerciseDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDbInstance(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smartprofilemanagement-app-db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}
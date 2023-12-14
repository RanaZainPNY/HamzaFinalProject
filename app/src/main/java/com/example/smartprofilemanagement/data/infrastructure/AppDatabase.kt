package com.example.smartprofilemanagement.data.infrastructure

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartprofilemanagement.data.daos.ProfileDao
import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.daos.UserDao
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.entities.User


@Database(
    entities = [
        Profile::class,
//        User::class,
//        Reminder::class,
//    Exercise::class,
               ],
    version = 5,
    exportSchema = true,
    autoMigrations = [
        AutoMigration (from = 4, to = 5)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
//    abstract fun userDao(): UserDao
//    abstract fun reminderDao(): ReminderDao

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
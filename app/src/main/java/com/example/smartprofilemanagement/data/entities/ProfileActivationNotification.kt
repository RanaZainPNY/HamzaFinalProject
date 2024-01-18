package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProfileActivationNotification")
data class ProfileActivationNotification(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("profileName") val profileName: String,
    @ColumnInfo("message")val message: String,
    @ColumnInfo("timestamp")val timestamp: Long,
)
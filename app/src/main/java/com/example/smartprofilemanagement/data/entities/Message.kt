package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")val id: Long = 0,
    @ColumnInfo("profileId")val profileId: Long?,
    @ColumnInfo("activationMessage")val activationMessage: String,
    @ColumnInfo("deactivationMessage")val deactivationMessage: String,
    @ColumnInfo("phoneNumber")val phoneNumber: String
)


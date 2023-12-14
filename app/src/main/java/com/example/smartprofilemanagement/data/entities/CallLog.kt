package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calllogs")
data class CallLog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("callerName") val callerName: String,
    @ColumnInfo("duration") val duration: Int,
    @ColumnInfo("timestamp") val timestamp:String
)
package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleeping_hours")
data class SleepingHours(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")val id: Long = 0,
    @ColumnInfo("profileId")val profileId: Long,
    @ColumnInfo("startTime")val startTime: Long,
    @ColumnInfo("endTime")val endTime: Long
)

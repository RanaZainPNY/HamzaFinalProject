package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Location(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("latitude") val latitude: Double ,
    @ColumnInfo("longtitude")val longitude: Double,
    @ColumnInfo("timestamp") val timestamp: Long
)

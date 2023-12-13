package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "profiles")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("username") var name: String,
    @ColumnInfo("profilename") var profileName: String?,
    @ColumnInfo("blackList") var blackList: String?,
    @ColumnInfo("latitude") var latitude: Double?,
    @ColumnInfo("longtitude") var longitude: Double?,
    @ColumnInfo("activationradius") var activationradius: Float?,
    @ColumnInfo("wifistatus") var wifiStatus: Boolean = false,
    @ColumnInfo("sleepinghoursStart") var sleepingHoursStart: Long?,
    @ColumnInfo("sleepinghoursEnd") var sleepingHoursEnd: Long?,
    @ColumnInfo("message") var message: String?,
    @ColumnInfo("location") var location: String?,
    @ColumnInfo("phoneNumber") var phoneNumber: String?,
    @ColumnInfo("description") var description: String?,
    @ColumnInfo("reminder") var reminder: String?,
    @ColumnInfo("timestamp") var timestamp: Long?,
    @ColumnInfo("isDone") var isDone: Boolean = false,
    @ColumnInfo("isDeleted") var isDeleted: Boolean = false,
    @ColumnInfo("title") var title: String?,
    @ColumnInfo("isActive") var isActive: Boolean = false
)

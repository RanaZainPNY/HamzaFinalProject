package com.example.smartprofilemanagement.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("username") var username: String,
    @ColumnInfo("password") var password: String,
)

package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.SleepingHours
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepingHoursDao : IDao<SleepingHours> {
    @Query("select * from sleeping_hours")
    override fun get(): List<SleepingHours>

    @Query("SELECT * from sleeping_hours WHERE id = :id")
    override fun get(id: Int): Flow<SleepingHours?>

    @Query("SELECT * from sleeping_hours ORDER BY id DESC")
    override fun getAll(): Flow<List<SleepingHours>>
}
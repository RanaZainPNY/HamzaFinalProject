package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao : IDao<Location> {
    @Query("select * from locations")
    override fun get(): List<Location>

    @Query("SELECT * from locations WHERE id = :id")
    override fun get(id: Int): Flow<Location?>

    @Query("SELECT * from locations ORDER BY id DESC")
    override fun getAll(): Flow<List<Location>>
}
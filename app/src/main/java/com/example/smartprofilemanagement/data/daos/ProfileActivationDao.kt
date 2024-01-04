package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileActivationDao : IDao<ProfileActivation> {
    @Query("select * from profileactivations")
    override fun get(): List<ProfileActivation>

    @Query("SELECT * from profileactivations WHERE id = :id")
    override fun get(id: Int): Flow<ProfileActivation?>

    @Query("SELECT * from profileactivations ORDER BY id DESC")
    override fun getAll(): Flow<List<ProfileActivation>>
}
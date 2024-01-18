package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.ProfileActivationNotification
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileActivationNotificationDao : IDao<ProfileActivationNotification> {
    @Query("select * from ProfileActivationNotification")
    override fun get(): List<ProfileActivationNotification>

    @Query("SELECT * from ProfileActivationNotification WHERE id = :id")
    override fun get(id: Int): Flow<ProfileActivationNotification?>

    @Query("SELECT * from ProfileActivationNotification ORDER BY id DESC")
    override fun getAll(): Flow<List<ProfileActivationNotification>>
}
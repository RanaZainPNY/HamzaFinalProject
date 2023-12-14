package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Exercise
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow


@Dao
interface MessageDao : IDao<Message> {
    @Query("select * from messages")
    override fun get(): List<Message>

    @Query("SELECT * from messages WHERE id = :id")
    override fun get(id: Int): Flow<Message?>

    @Query("SELECT * from messages ORDER BY id DESC")
    override fun getAll(): Flow<List<Message>>
}
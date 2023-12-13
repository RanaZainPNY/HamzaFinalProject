package com.example.smartprofilemanagement.data.daos
import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Exercise
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow


@Dao
interface ReminderDao : IDao<Reminder> {
    @Query("select * from reminders")
    override fun get(): List<Reminder>

    @Query("SELECT * from reminders WHERE id = :id")
    override fun get(id: Int): Flow<Reminder?>

    @Query("SELECT * from reminders ORDER BY id DESC")
    override fun getAll(): Flow<List<Reminder>>
}
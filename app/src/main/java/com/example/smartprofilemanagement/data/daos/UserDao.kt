package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.entities.User
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao : IDao<User> {
    @Query("select * from users")
    override fun get(): List<User>

    @Query("SELECT * from users WHERE id = :id")
    override fun get(id: Int): Flow<User?>

    @Query("SELECT * from users ORDER BY id DESC")
    override fun getAll(): Flow<List<User>>

}
package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.CallBlock
import com.example.smartprofilemanagement.data.entities.CallLog
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface CallBlockDao : IDao<CallBlock> {
    @Query("select * from calllogs")
    override fun get(): List<CallBlock>

    @Query("SELECT * from calllogs WHERE id = :id")
    override fun get(id: Int): Flow<CallBlock?>

    @Query("SELECT * from calllogs ORDER BY id DESC")
    override fun getAll(): Flow<List<CallBlock>>
}
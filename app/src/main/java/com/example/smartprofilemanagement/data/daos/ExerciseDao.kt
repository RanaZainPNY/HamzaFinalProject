package com.example.smartprofilemanagement.data.daos


import androidx.room.Dao
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Exercise
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao : IDao<Exercise> {
    @Query("select * from exercises")
    override fun get(): List<Exercise>

    @Query("SELECT * from exercises WHERE id = :id")
    override fun get(id: Int): Flow<Exercise?>

    @Query("SELECT * from exercises ORDER BY id DESC")
    override fun getAll(): Flow<List<Exercise>>
}
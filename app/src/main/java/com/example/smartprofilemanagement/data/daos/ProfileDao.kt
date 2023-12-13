package com.example.smartprofilemanagement.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.infrastructure.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao : IDao<Profile> {

    //////////////// Methods from Generic Interface Implementation   ////////////////
    @Query("select * from profiles")
    override fun get(): List<Profile>

    @Query("SELECT * from profiles WHERE id = :id")
    override fun get(id: Int): Flow<Profile?>

    @Query("SELECT * from profiles ORDER BY id DESC")
    override fun getAll(): Flow<List<Profile>>


    //////////////// Methods from Hamza DAO   ////////////////
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile: Profile)

//    @Delete
//    suspend fun deleteProfile(profile: Int)
//
//    @Query("SELECT * FROM profiles")
//    suspend fun getAllProfiles(): List<Profile>
//
//    @Update
//    suspend fun updateProfile(profile: Profile)
//
//    @Edit
//    suspend fun editProfile(profile: Profile)
//
//    @Insert
//    suspend fun insertProfile(profile: Profile)
//    fun getAllProfilesList(): List<Profile> {
//        TODO("Not yet implemented")
//    }
//
//    annotation class Edit
}
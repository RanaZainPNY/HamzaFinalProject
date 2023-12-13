package com.example.smartprofilemanagement.data.repositories

import android.os.Parcel
import android.os.Parcelable
import com.example.smartprofilemanagement.data.daos.ProfileDao
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileRepository(
    dao: ProfileDao,
    allItems: Flow<List<Profile>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<Profile>> = MutableStateFlow(emptyList())
) : Repository<Profile, ProfileDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
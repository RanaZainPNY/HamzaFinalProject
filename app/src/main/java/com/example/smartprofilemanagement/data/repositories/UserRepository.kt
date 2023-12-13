package com.example.smartprofilemanagement.data.repositories

import android.os.Parcel
import android.os.Parcelable
import com.example.smartprofilemanagement.data.daos.ProfileDao
import com.example.smartprofilemanagement.data.daos.UserDao
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.entities.User
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class UserRepository(
    dao: UserDao,
    allItems: Flow<List<User>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
) : Repository<User, UserDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
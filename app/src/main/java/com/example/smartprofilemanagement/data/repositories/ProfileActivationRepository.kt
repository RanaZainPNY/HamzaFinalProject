package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.LocationDao
import com.example.smartprofilemanagement.data.daos.ProfileActivationDao
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.infrastructure.Repository
import com.example.smartprofilemanagement.ui.navigation.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileActivationRepository(
    dao: ProfileActivationDao,
    allItems: Flow<List<ProfileActivation>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<ProfileActivation>> = MutableStateFlow(emptyList())
) : Repository<ProfileActivation, ProfileActivationDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
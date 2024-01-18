package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.ProfileActivationDao
import com.example.smartprofilemanagement.data.daos.ProfileActivationNotificationDao
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.entities.ProfileActivationNotification
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileActivationNotificationRepository(
    dao: ProfileActivationNotificationDao,
    allItems: Flow<List<ProfileActivationNotification>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<ProfileActivationNotification>> = MutableStateFlow(emptyList())
) : Repository<ProfileActivationNotification, ProfileActivationNotificationDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
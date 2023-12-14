package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.LocationDao
import com.example.smartprofilemanagement.data.daos.MessageDao
import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LocationRepository(
    dao: LocationDao,
    allItems: Flow<List<Location>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<Location>> = MutableStateFlow(emptyList())
) : Repository<Location, LocationDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
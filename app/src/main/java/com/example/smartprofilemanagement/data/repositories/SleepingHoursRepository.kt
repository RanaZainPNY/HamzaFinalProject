package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.MessageDao
import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.daos.SleepingHoursDao
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.entities.SleepingHours
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SleepingHoursRepository(
    dao: SleepingHoursDao,
    allItems: Flow<List<SleepingHours>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<SleepingHours>> = MutableStateFlow(emptyList())
) : Repository<SleepingHours, SleepingHoursDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}

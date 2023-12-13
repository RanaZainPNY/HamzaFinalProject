package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ReminderRepository(
    dao: ReminderDao,
    allItems: Flow<List<Reminder>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<Reminder>> = MutableStateFlow(emptyList())
) : Repository<Reminder, ReminderDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
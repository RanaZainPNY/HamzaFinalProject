package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.MessageDao
import com.example.smartprofilemanagement.data.daos.ReminderDao
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MessageRepository(
    dao: MessageDao,
    allItems: Flow<List<Message>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<Message>> = MutableStateFlow(emptyList())
) : Repository<Message, MessageDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
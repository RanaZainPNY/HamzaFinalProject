package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.CallLogDao
import com.example.smartprofilemanagement.data.entities.CallLog
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CallLogRepository(
    dao: CallLogDao,
    allItems: Flow<List<CallLog>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<CallLog>> = MutableStateFlow(emptyList())
) : Repository<CallLog, CallLogDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
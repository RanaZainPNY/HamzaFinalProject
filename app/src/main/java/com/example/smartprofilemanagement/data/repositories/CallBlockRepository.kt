package com.example.smartprofilemanagement.data.repositories

import com.example.smartprofilemanagement.data.daos.CallBlockDao
import com.example.smartprofilemanagement.data.daos.CallLogDao
import com.example.smartprofilemanagement.data.entities.CallBlock
import com.example.smartprofilemanagement.data.entities.CallLog
import com.example.smartprofilemanagement.data.infrastructure.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CallBlockRepository(
    dao: CallBlockDao,
    allItems: Flow<List<CallBlock>> = MutableStateFlow(emptyList()),
    searchResults: MutableStateFlow<List<CallBlock>> = MutableStateFlow(emptyList())
) : Repository<CallBlock, CallBlockDao>(dao, allItems, searchResults) {

    init {
        this.allItems = dao.getAll()
    }

}
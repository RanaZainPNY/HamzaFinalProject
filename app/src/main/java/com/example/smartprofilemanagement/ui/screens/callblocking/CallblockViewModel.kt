package com.example.smartprofilemanagement.ui.screens.callblocking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.smartprofilemanagement.data.entities.CallBlock
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.repositories.CallBlockRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CallblockViewModel(private val repository: CallBlockRepository) : ViewModel() {
//    val counterHome: Int = 999

    val callBlockUiState: StateFlow<CallBlockUiState> =
        repository.getAll().map { CallBlockUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = CallBlockUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<CallBlock>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<CallBlock>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: CallBlock) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: CallBlock, listToUpdate: List<CallBlock>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: CallBlock) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { callBlockList ->
                    _items.value = callBlockList.toMutableStateList()
                }
        }
    }

    init {
        initializeList()
    }

}

/**
 * Ui State for HomeScreen
 */
data class CallBlockUiState(val itemList: List<CallBlock> = listOf())

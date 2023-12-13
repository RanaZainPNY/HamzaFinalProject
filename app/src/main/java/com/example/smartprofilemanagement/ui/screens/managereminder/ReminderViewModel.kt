package com.example.smartprofilemanagement.ui.screens.managereminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReminderViewModel(private val repository: ReminderRepository) : ViewModel() {
//    val counterHome: Int = 999

    val reminderUiState: StateFlow<ReminderUiState> =
        repository.getAll().map { ReminderUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ReminderUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<Reminder>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<Reminder>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: Reminder) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: Reminder, listToUpdate: List<Reminder>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: Reminder) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { reminderList ->
                    _items.value = reminderList.toMutableStateList()
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
data class ReminderUiState(val itemList: List<Reminder> = listOf())

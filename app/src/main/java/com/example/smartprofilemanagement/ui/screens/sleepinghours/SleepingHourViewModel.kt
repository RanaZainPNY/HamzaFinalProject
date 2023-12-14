package com.example.smartprofilemanagement.ui.screens.sleepinghours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.SleepingHours
import com.example.smartprofilemanagement.data.repositories.SleepingHoursRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SleepingHourViewModel(private val repository: SleepingHoursRepository) : ViewModel() {
//    val counterHome: Int = 999

    val sleepingHoursUiState: StateFlow<SleepingHoursUiState> =
        repository.getAll().map { SleepingHoursUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SleepingHoursUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<SleepingHours>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<SleepingHours>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: SleepingHours) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: SleepingHours, listToUpdate: List<SleepingHours>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: SleepingHours) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { sleepingHoursList ->
                    _items.value = sleepingHoursList.toMutableStateList()
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
data class SleepingHoursUiState(val itemList: List<SleepingHours> = listOf())

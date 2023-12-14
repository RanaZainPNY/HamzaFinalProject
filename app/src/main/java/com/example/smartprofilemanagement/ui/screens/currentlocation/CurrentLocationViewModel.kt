package com.example.smartprofilemanagement.ui.screens.currentlocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.repositories.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrentLocationViewModel(private val repository: LocationRepository) : ViewModel() {
//    val counterHome: Int = 999

    val locationUiState: StateFlow<LocationUiState> =
        repository.getAll().map { LocationUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = LocationUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<Location>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<Location>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: Location) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: Location, listToUpdate: List<Location>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: Location) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { locationList ->
                    _items.value = locationList.toMutableStateList()
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
data class LocationUiState(val itemList: List<Location> = listOf())

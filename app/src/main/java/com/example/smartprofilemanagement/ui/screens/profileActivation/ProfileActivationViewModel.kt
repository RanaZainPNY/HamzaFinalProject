package com.example.smartprofilemanagement.ui.screens.profileActivation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.repositories.LocationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileActivationViewModel(private val repository: ProfileActivationRepository) : ViewModel() {
//    val counterHome: Int = 999

    val ProfileActivationUiState: StateFlow<ProfileActivationUiState> =
        repository.getAll().map { ProfileActivationUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ProfileActivationUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<ProfileActivation>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<ProfileActivation>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: ProfileActivation) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: ProfileActivation, listToUpdate: List<ProfileActivation>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: ProfileActivation) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { profileactivationList ->
                    _items.value = profileactivationList.toMutableStateList()
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
data class ProfileActivationUiState(val itemList: List<ProfileActivation> = listOf())

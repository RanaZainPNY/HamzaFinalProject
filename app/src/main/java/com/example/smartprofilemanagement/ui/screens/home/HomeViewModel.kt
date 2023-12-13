package com.example.smartprofilemanagement.ui.screens.home

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.repositories.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ProfileRepository) : ViewModel() {
//    val counterHome: Int = 999

    val profileUiState: StateFlow<ProfileUiState> =
        repository.getAll().map { ProfileUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ProfileUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<Profile>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<Profile>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: Profile) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: Profile, listToUpdate: List<Profile>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: Profile) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { profileList ->
                    _items.value = profileList.toMutableStateList()
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
data class ProfileUiState(val itemList: List<Profile> = listOf())

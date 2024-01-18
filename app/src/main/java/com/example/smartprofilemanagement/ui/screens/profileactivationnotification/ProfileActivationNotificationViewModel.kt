package com.example.smartprofilemanagement.ui.screens.profileactivationnotification
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartprofilemanagement.data.entities.Location
import com.example.smartprofilemanagement.data.entities.ProfileActivation
import com.example.smartprofilemanagement.data.entities.ProfileActivationNotification
import com.example.smartprofilemanagement.data.repositories.LocationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationNotificationRepository
import com.example.smartprofilemanagement.data.repositories.ProfileActivationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileActivationNotificationViewModel(private val repository: ProfileActivationNotificationRepository) : ViewModel() {
//    val counterHome: Int = 999

    val ProfileActivationNotificationUiState: StateFlow<ProfileActivationNotificationUiState> =
        repository.getAll().map { ProfileActivationNotificationUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ProfileActivationNotificationUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<ProfileActivationNotification>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<ProfileActivationNotification>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: ProfileActivationNotification) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: ProfileActivationNotification, listToUpdate: List<ProfileActivationNotification>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: ProfileActivationNotification) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { profileactivationnotificationList ->
                    _items.value = profileactivationnotificationList.toMutableStateList()
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
data class ProfileActivationNotificationUiState(val itemList: List<ProfileActivationNotification> = listOf())

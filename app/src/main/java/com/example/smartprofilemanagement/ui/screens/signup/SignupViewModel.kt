package com.example.smartprofilemanagement.ui.screens.signup

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartprofilemanagement.data.entities.Profile
import com.example.smartprofilemanagement.data.entities.User
import com.example.smartprofilemanagement.data.repositories.UserRepository
import com.example.smartprofilemanagement.ui.screens.profile.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SignupViewModel(private val repository: UserRepository): ViewModel() {

    val SignupUiState: StateFlow<SignupUiState> =
        repository.getAll().map { SignupUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SignupUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }


    private val _items = MutableStateFlow<SnapshotStateList<User>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<User>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: User) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }


    internal fun update(model: User, listToUpdate: List<User>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: User) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }

    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { userList ->
                    _items.value = userList.toMutableStateList()
                }
        }
    }

    init{

        initializeList()
    }


}


data class SignupUiState(val itemList: List<User> = listOf())
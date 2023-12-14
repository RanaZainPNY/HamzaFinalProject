package com.example.smartprofilemanagement.ui.screens.messagenotification


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.smartprofilemanagement.data.entities.Message
import com.example.smartprofilemanagement.data.entities.Reminder
import com.example.smartprofilemanagement.data.repositories.MessageRepository
import com.example.smartprofilemanagement.data.repositories.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageNotificationViewModel(private val repository: MessageRepository) : ViewModel() {
//    val counterHome: Int = 999

    val messageUiState: StateFlow<MessageUiState> =
        repository.getAll().map { MessageUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = MessageUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _items = MutableStateFlow<SnapshotStateList<Message>>(SnapshotStateList())
    val items = _items.asStateFlow()


    internal fun getList(): StateFlow<SnapshotStateList<Message>> {
        return _items.asStateFlow()
    }


    internal fun insert(model: Message) {
        viewModelScope.launch {
            repository.insert(model)
            _items.emit(items.value)
        }
    }

    internal fun update(model: Message, listToUpdate: List<Message>) {
        viewModelScope.launch {
            repository.update(model)
            _items.value = listToUpdate.toMutableStateList()
        }
    }

    internal fun delete(model: Message) {
        viewModelScope.launch {
            repository.delete(model)
            _items.emit(items.value)
        }
    }


    private fun initializeList() {
        viewModelScope.launch {
            repository.allItems
                .collect { messageList ->
                    _items.value = messageList.toMutableStateList()
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
data class MessageUiState(val itemList: List<Message> = listOf())

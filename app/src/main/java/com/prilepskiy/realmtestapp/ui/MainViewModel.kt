package com.prilepskiy.realmtestapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.realmtestapp.domain.interactor.AddUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.DeleteUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.GetUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.GetUsersUseCase
import com.prilepskiy.realmtestapp.domain.interactor.UpdateUserUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase

) : ViewModel() {


    fun addUser(user: UserModel) {
        viewModelScope.launch { addUserUseCase.invoke(user) }
    }

    fun deleteUser(user: UserModel) {
        viewModelScope.launch { deleteUserUseCase.invoke(user) }
    }

    fun getUsers() {
        viewModelScope.launch { getUsersUseCase.invoke() }
    }

    fun getUser(id: Long) {
        viewModelScope.launch { getUserUseCase.invoke(id) }
    }

    fun updateUser(user: UserModel) {
        viewModelScope.launch { updateUserUseCase.invoke(user) }
    }

}
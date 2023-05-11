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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    private val _emailState: MutableStateFlow<String?> by lazy { MutableStateFlow(null) }
    private val _passState: MutableStateFlow<String?> by lazy { MutableStateFlow(null) }
    val emailState=_emailState.asStateFlow()
    val passState=_passState.asStateFlow()

    private val _userState: MutableStateFlow<UserModel?> by lazy { MutableStateFlow(null) }
    val userState=_userState.asStateFlow()

    fun setEmail(email:String){
        viewModelScope.launch {
            _emailState.emit(email)
        }

    }

    fun setPass(pass:String){
        viewModelScope.launch {
            _passState.emit(pass)
        }

    }

    fun addUser(user: UserModel) {
        viewModelScope.launch { addUserUseCase.invoke(user) }
    }

    fun deleteUser(user: UserModel) {
        viewModelScope.launch { deleteUserUseCase.invoke(user) }
    }

    fun getUsers() {
        viewModelScope.launch { getUsersUseCase.invoke() }
    }

   private fun loginUser() {
        viewModelScope.launch {
            _userState.emit(getUserUseCase.invoke(emailState.value.toString()))

        }
    }
    fun resetPassUser(email: String){
        viewModelScope.launch {
            val user= getUserUseCase.invoke(emailState.value.toString())
            if (user!=null) updateUser(user)
        }
    }

    fun updateUser(user: UserModel) {
        viewModelScope.launch { updateUserUseCase.invoke(user) }
    }

}
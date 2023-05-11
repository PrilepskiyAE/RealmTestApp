package com.prilepskiy.realmtestapp.domain.usecase

import com.prilepskiy.realmtestapp.domain.interactor.AddUserUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddUserUseCaseImpl(private val rep:AuthRepository): AddUserUseCase {
    override suspend operator fun invoke(user: UserModel) = withContext(Dispatchers.IO){
        rep.addUser(user)
    }
}
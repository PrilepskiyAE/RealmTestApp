package com.prilepskiy.realmtestapp.domain.usecase

import com.prilepskiy.realmtestapp.domain.interactor.DeleteUserUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteUserUseCaseImpl(private val rep: AuthRepository): DeleteUserUseCase {
    override suspend operator fun invoke(user: UserModel) = withContext(Dispatchers.IO){
        rep.deleteUser(user)
    }
}
package com.prilepskiy.realmtestapp.domain.usecase

import com.prilepskiy.realmtestapp.domain.interactor.UpdateUserUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateUserUseCaseImpl(private val rep: AuthRepository): UpdateUserUseCase {
    override suspend operator fun invoke(user: UserModel) = withContext(Dispatchers.IO){
        rep.updateUser(user)
    }
}
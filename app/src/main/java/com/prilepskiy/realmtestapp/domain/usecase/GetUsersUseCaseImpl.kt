package com.prilepskiy.realmtestapp.domain.usecase

import com.prilepskiy.realmtestapp.domain.interactor.GetUsersUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUsersUseCaseImpl(private val rep: AuthRepository): GetUsersUseCase {
    override suspend operator fun invoke(): List<UserModel> = withContext(Dispatchers.IO){
        return@withContext rep.getUsers()
    }
}
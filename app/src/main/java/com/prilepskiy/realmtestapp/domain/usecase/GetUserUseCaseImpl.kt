package com.prilepskiy.realmtestapp.domain.usecase

import com.prilepskiy.realmtestapp.domain.interactor.GetUserUseCase
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserUseCaseImpl(private val rep: AuthRepository): GetUserUseCase {
    override suspend fun invoke(email:String): UserModel? = withContext(Dispatchers.IO){
        return@withContext rep.getUser(email)
    }
}
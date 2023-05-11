package com.prilepskiy.realmtestapp.data.repository

import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl@Inject constructor(): AuthRepository {
    override suspend fun addUser(user: UserModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getUsers(): List<UserModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(email:String): UserModel? {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: UserModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: UserModel) {
        TODO("Not yet implemented")
    }
}
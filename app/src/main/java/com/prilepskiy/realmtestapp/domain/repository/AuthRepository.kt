package com.prilepskiy.realmtestapp.domain.repository

import com.prilepskiy.realmtestapp.domain.model.UserModel

interface AuthRepository {
    suspend fun addUser(user:UserModel)
    suspend fun getUsers():List<UserModel>
    suspend fun getUser(id:Long):UserModel
    suspend fun updateUser(user: UserModel)
    suspend fun deleteUser(user: UserModel)
}
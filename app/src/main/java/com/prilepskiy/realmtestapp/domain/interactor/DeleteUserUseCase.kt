package com.prilepskiy.realmtestapp.domain.interactor

import com.prilepskiy.realmtestapp.domain.model.UserModel

interface DeleteUserUseCase {
    suspend operator fun invoke(user: UserModel)
}
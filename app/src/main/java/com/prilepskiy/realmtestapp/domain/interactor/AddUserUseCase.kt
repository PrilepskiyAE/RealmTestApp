package com.prilepskiy.realmtestapp.domain.interactor

import com.prilepskiy.realmtestapp.domain.model.UserModel

interface AddUserUseCase {
    suspend operator fun invoke(user: UserModel)
}
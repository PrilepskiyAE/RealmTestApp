package com.prilepskiy.realmtestapp.domain.interactor

import com.prilepskiy.realmtestapp.domain.model.UserModel

interface GetUserUseCase {
    suspend operator fun invoke(id:Long):UserModel
}
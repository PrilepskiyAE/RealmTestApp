package com.prilepskiy.realmtestapp.domain.interactor

import com.prilepskiy.realmtestapp.domain.model.UserModel

interface GetUsersUseCase
{
    suspend operator fun invoke():List<UserModel>
}
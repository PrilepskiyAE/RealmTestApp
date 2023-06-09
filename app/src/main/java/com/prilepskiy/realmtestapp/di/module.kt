package com.prilepskiy.realmtestapp.di

import com.prilepskiy.realmtestapp.data.dataservice.UserEntity
import com.prilepskiy.realmtestapp.data.repository.AuthRepositoryImpl
import com.prilepskiy.realmtestapp.domain.interactor.AddUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.DeleteUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.GetUserUseCase
import com.prilepskiy.realmtestapp.domain.interactor.GetUsersUseCase
import com.prilepskiy.realmtestapp.domain.interactor.UpdateUserUseCase
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import com.prilepskiy.realmtestapp.domain.usecase.AddUserUseCaseImpl
import com.prilepskiy.realmtestapp.domain.usecase.DeleteUserUseCaseImpl
import com.prilepskiy.realmtestapp.domain.usecase.GetUserUseCaseImpl
import com.prilepskiy.realmtestapp.domain.usecase.GetUsersUseCaseImpl
import com.prilepskiy.realmtestapp.domain.usecase.UpdateUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
class RealmModule{
    @Provides
    fun provideRepositoryModule(): Realm{
        val config = RealmConfiguration.create(schema = setOf(UserEntity::class))

        return Realm.open(config)
    }
}
@Module
@InstallIn(ViewModelComponent::class)
class  AuthRepositoryModule {
    @Provides
    fun provideRepositoryModule(db:Realm): AuthRepository = AuthRepositoryImpl(db)
}
@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideAddUserUseCaseModule(repo:AuthRepository): AddUserUseCase = AddUserUseCaseImpl(repo)

    @Provides
    fun provideDeleteUserUseCaseModule(repo:AuthRepository): DeleteUserUseCase = DeleteUserUseCaseImpl(repo)
    @Provides
    fun provideGetUsersUseCaseModule(repo:AuthRepository): GetUsersUseCase = GetUsersUseCaseImpl(repo)
    @Provides
    fun provideGetUserUseCaseModule(repo:AuthRepository): GetUserUseCase = GetUserUseCaseImpl(repo)
    @Provides
    fun provideUpdateUserUseCaseModule(repo:AuthRepository): UpdateUserUseCase = UpdateUserUseCaseImpl(repo)
}
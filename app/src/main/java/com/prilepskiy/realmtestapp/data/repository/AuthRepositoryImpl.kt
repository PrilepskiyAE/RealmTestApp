package com.prilepskiy.realmtestapp.data.repository

import android.util.Log
import com.prilepskiy.realmtestapp.data.dataservice.UserEntity
import com.prilepskiy.realmtestapp.domain.model.UserModel
import com.prilepskiy.realmtestapp.domain.repository.AuthRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import javax.inject.Inject

class AuthRepositoryImpl@Inject constructor(private val db: Realm): AuthRepository {
    override suspend fun addUser(user: UserModel) {
        db.writeBlocking {
            copyToRealm(
                UserEntity().apply {
                    this.name=user.name
                    this.address=user.address
                    this.email=user.email
                    this.pass=user.pass

                }
            )
        }
        val items: RealmResults<UserEntity> = db.query<UserEntity>().find()
        Log.d("TAG", "All User: $items ")
    }

    override suspend fun getUsers(): List<UserModel> {
        val items: RealmResults<UserEntity> = db.query<UserEntity>().find()
        val result:MutableList<UserModel> = mutableListOf()
        items.forEach {
            result.add(UserModel(
                id=it.id,
                name = it.name,
                email = it.email,
                pass=it.pass,
                address = it.address


            ))
        }
        return result
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
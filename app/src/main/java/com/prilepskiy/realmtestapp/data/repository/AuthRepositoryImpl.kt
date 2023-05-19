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
        val inEmailItems: RealmResults<UserEntity> =
            db.query<UserEntity>("email == $email")
                .find()
       if(inEmailItems.size>1){
           Log.d("TAG", "getUser warning: ${inEmailItems.size}")
           Log.d("TAG", "getUser -> warning: $inEmailItems")
       }
        return UserModel(
            id=inEmailItems[0].id,
            name = inEmailItems[0].name,
            email = inEmailItems[0].email,
            pass=inEmailItems[0].pass,
            address = inEmailItems[0].address)
    }

    override suspend fun updateUser(user: UserModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: UserModel) {
        TODO("Not yet implemented")
    }
}
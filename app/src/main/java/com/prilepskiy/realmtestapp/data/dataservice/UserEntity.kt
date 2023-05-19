package com.prilepskiy.realmtestapp.data.dataservice

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class UserEntity(): RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    @Index
    var name:String=""
    var email:String=""
    var pass:String=""
    var address:String=""
    override fun toString(): String {
        return "$id, $name, $email, $pass, $address"
    }
}
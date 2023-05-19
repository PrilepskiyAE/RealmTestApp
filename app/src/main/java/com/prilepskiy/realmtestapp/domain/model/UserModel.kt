package com.prilepskiy.realmtestapp.domain.model

import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

data class UserModel( val id:ObjectId = ObjectId(),
                      val name:String,
                      val email:String,
                      val pass:String,
                      val address:String )

package com.prilepskiy.realmtestapp.domain.model

data class UserModel(private val id:Long,
                     private val name:String,
                     private val email:String,
                     private val pass:String,
                     private val address:String )

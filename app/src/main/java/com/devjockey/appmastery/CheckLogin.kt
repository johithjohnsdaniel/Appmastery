package com.devjockey.appmastery

data class CheckLogin(val name:String,val password:String) {

    //login check
    fun checkLogin():Boolean{

        return this.name=="appmastery"&&this.password=="app"

    }

   // validation
    fun validation():Boolean{



        return !(this.name.isEmpty()&&this.password.isEmpty())


    }

}
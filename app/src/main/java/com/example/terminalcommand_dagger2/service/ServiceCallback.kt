package com.example.terminalcommand_dagger2.service

interface ServiceCallback<T> {

    fun onSuccess(response:T?)
    fun onError(errorCode:Int,errorMessage:String)
}
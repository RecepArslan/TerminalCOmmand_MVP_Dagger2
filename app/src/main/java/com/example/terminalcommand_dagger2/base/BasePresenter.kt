package com.example.terminalcommand_dagger2.base

import com.example.terminalcommand_dagger2.service.DataManager
import javax.inject.Inject

open class BasePresenter<V : MvpView> constructor(dataManager: DataManager) : MvpPresenter<V> {
    lateinit var mvpView: V
    var dataManager: DataManager
        @Inject set

    init {
        this.dataManager = dataManager
    }

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    fun onCreated(){

    }


}


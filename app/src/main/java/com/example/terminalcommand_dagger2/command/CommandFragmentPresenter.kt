package com.example.terminalcommand_dagger2.command

import android.view.View
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.service.DataManager
import com.example.terminalcommand_dagger2.service.ServiceCallback
import javax.inject.Inject

class CommandFragmentPresenter @Inject
constructor(dataManager: DataManager) :
    CommandListFragmentMvpPresenter {
    lateinit var myView:CommandListFragmentMvpView
    lateinit var root: View
    var dataManager: DataManager
        @Inject set

    init {
        this.dataManager = dataManager
    }

    override fun setView(root: View, commandListFragment: CommandListFragment) {
        this.myView = commandListFragment
        this.root = root
    }

    override fun getCommandsOfCategory(position: String) {
    myView.showLoading()
        dataManager.getCommandsOfCategory(position,object :ServiceCallback<List<CommandModel>>{
            override fun onSuccess(response: List<CommandModel>?) {

               myView.loadDataToList(response!!)
                myView.hideLoading()
            }

            override fun onError(errorCode: Int, errorMessage: String) {

            }


        })



    }


}
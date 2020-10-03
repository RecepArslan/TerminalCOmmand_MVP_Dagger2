package com.example.terminalcommand_dagger2.command

import android.view.View
import com.example.terminalcommand_dagger2.base.BasePresenter
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.service.DataManager
import com.example.terminalcommand_dagger2.service.ServiceCallback
import javax.inject.Inject

class CommandFragmentPresenter<V : CommandListFragmentMvpView>
@Inject
constructor(dataManager: DataManager) : BasePresenter<V>(dataManager),
    CommandListFragmentMvpPresenter<V> {


    override fun getCommandsOfCategory(position: String) {
        mvpView.showLoading()
        dataManager.getCommandsOfCategory(position, object : ServiceCallback<List<CommandModel>> {
            override fun onSuccess(response: List<CommandModel>?) {
                if (response != null) {
                    mvpView.loadDataToList(response)
                    mvpView.hideLoading()
                }
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.hideLoading()
                mvpView.showText(errorMessage)
            }


        })


    }


}
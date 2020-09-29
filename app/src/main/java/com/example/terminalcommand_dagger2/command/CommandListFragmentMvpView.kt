package com.example.terminalcommand_dagger2.command

import com.example.terminalcommand_dagger2.models.CommandModel

interface CommandListFragmentMvpView {


    fun loadDataToList(response: List<CommandModel>?)
    fun showLoading()
    fun hideLoading()
}
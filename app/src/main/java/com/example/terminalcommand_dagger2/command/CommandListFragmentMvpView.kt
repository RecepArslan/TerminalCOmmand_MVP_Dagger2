package com.example.terminalcommand_dagger2.command

import com.example.terminalcommand_dagger2.base.MvpView
import com.example.terminalcommand_dagger2.models.CommandModel

interface CommandListFragmentMvpView:MvpView{


    fun loadDataToList(response: List<CommandModel>?)
}
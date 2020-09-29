package com.example.terminalcommand_dagger2.command

import android.view.View

interface CommandListFragmentMvpPresenter {
    fun setView(root: View, commandListFragment: CommandListFragment)
    fun getCommandsOfCategory(position: String)


}
package com.example.terminalcommand_dagger2.command

import android.view.View
import com.example.terminalcommand_dagger2.base.MvpPresenter

interface CommandListFragmentMvpPresenter<V:CommandListFragmentMvpView>:MvpPresenter<V> {
    fun getCommandsOfCategory(position: String)


}
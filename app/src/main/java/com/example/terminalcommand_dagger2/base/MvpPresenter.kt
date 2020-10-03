package com.example.terminalcommand_dagger2.base

interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)
}
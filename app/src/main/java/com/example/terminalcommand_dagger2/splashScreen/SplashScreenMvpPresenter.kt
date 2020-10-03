package com.example.terminalcommand_dagger2.splashScreen

import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpView
import com.example.terminalcommand_dagger2.base.MvpPresenter

interface SplashScreenMvpPresenter<V: SplashScreenMvpView>: MvpPresenter<V> {

    fun startWaiting()
}
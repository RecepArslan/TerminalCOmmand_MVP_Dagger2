package com.example.terminalcommand_dagger2.splashScreen

import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpPresenter
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpView
import com.example.terminalcommand_dagger2.base.BasePresenter
import com.example.terminalcommand_dagger2.service.DataManager
import com.example.terminalcommand_dagger2.splashScreenSleepTime
import javax.inject.Inject

class SpashScreenPresenter<V : SplashScreenMvpView>
@Inject constructor(dataManager: DataManager) : BasePresenter<V>(dataManager),
    SplashScreenMvpPresenter<V> {
    override fun startWaiting() {

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(splashScreenSleepTime)
                    mvpView.openCategoriesFragment()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

        }
        thread.start()

    }


}